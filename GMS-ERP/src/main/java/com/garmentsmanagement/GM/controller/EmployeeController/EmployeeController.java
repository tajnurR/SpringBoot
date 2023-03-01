package com.garmentsmanagement.GM.controller.EmployeeController;

import com.garmentsmanagement.GM.entity.employeeEntity.Employees;
import com.garmentsmanagement.GM.entity.employeeEntity.SalaryGrade;
import com.garmentsmanagement.GM.entity.employeeEntity.Department;
import com.garmentsmanagement.GM.entity.employeeEntity.Designation;
import com.garmentsmanagement.GM.repository.EmployeeRepository.DesignationRepo;
import com.garmentsmanagement.GM.repository.EmployeeRepository.SalaryGradeRepo;
import com.garmentsmanagement.GM.service.employeeService.DeptService;
import com.garmentsmanagement.GM.service.employeeService.EmployeeService;
import com.garmentsmanagement.GM.service.FileUploadService;
import com.garmentsmanagement.GM.utility.EmployeeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    SalaryGradeRepo sgRepo;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeUtility employeeUtility;

    @Autowired
    DeptService deptService;


    @Autowired
    DesignationRepo desigRepo;

    @Autowired
    FileUploadService fileUploadService;

    //    Add New Grede
    @RequestMapping("/add_grede")
    public String gredeAdd(@ModelAttribute("add_grade") SalaryGrade sg){
        employeeUtility.setSalryExtension(sg);
        sgRepo.save(sg);
        return "redirect:/user/all-grede";
    }

    //    Show All Grede in table
    @RequestMapping("/user/all-grede")
    public String showGrade(Model m, @ModelAttribute("add_grade") SalaryGrade sg){
        List<SalaryGrade> allg = employeeService.getAllGrade();
        m.addAttribute("allgrede", allg);
        return "emp_add_grade";
    }


//    Update Grete
    @RequestMapping("/update-sg/{sg_id}")
    public String updateGrade(@PathVariable("sg_id") Long sg_id, @ModelAttribute("add_grade") SalaryGrade sg , Model m) {
        System.out.println(sg_id);
        SalaryGrade e = employeeService.findGredeById(sg_id);
        m.addAttribute("add_grade", e);

        return "emp_add_grade";
    }

    // Delete Grede
    @RequestMapping("/delete-sg/{sg_id}")
    public String deleteGrede(@ModelAttribute("add_grade") SalaryGrade sg, @PathVariable("sg_id")Long sg_id, Model m){
        employeeService.deleteGrade(sg_id);
        return "redirect:/user/all-grede";
    }

//    Designation section
    @RequestMapping("/user/add-desig")
    public String addTitlePage( Model m){
        m.addAttribute("addDesig", new Designation());
        m.addAttribute("allDept", deptService.findAllDept());
        m.addAttribute("allGrade", employeeService.getAllGrade());
        return "emp_add_dep";
    }

    @RequestMapping("/user/submit-desig")
    public String saveDesgi(@ModelAttribute("addDesig")Designation dg, Model m){

        deptService.saveDesig(dg);
        return "redirect:/user/add-desig";
    }

    @RequestMapping("/hr")
    public String hrDashboard() {

        return "hrDashboard";
    }


    @RequestMapping("/user/emp_all")
    public String allEmployee(Model m) {
        List<Employees> emList = employeeService.findAllEms();
        if (!emList.isEmpty()){
            m.addAttribute("emList", emList);
        }else{
            m.addAttribute("noEmAvaiable", "NO Employ add yet");
        }

        return "emp_all";
    }

    @RequestMapping("/user/emp_create")
    public String createEmp(@ModelAttribute("emp") Employees hem, Model m) {
        List<Department> deptList = deptService.findAllDept();
        m.addAttribute("depList", deptList);
        return "emp_create_new";
    }

    @RequestMapping(value = "/emp_save")
    public String saveEmp(@ModelAttribute("emp") Employees hre, @RequestParam("pimg")MultipartFile file, Model m) throws IOException {
        String imageName = fileUploadService.uploadImage(file);
        hre.setEm_profileImg(imageName);

        String deptName = hre.getDepartment().getDep_SortName();
        String year = hre.getEm_joiningDate();
        String grade = hre.getDesignation().getSalaryGrade().getSg_name();
        int empNumer = employeeService.getTotalEmp();

        hre.setEm_employeeID(employeeUtility.generateEmpId(deptName,year,grade,empNumer));
        employeeService.saveExployee(hre);
        return "redirect:/user/emp_all";
    }

//        @RequestMapping("/imsge/{fileName}")
//    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
//        byte[] imageData= fileUploadService.downloadImage(fileName);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.valueOf("image/png"))
//                .body(imageData);
//
//    }

    @RequestMapping("/profile/{id}")
    public String showProfile(@RequestParam("id")long id, Model m){
        
              m.addAttribute("allEmp", employeeService.findEmpById(id));

        return "emp_profile";
    }

    @RequestMapping("/attendance_live")
    public String test(){
        return "qr";
    }

    @RequestMapping("/scranok")
    public String test1(){
        return "attendance_live";
    }



}
