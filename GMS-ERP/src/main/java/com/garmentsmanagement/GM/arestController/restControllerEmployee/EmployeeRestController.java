package com.garmentsmanagement.GM.arestController.restControllerEmployee;

import com.garmentsmanagement.GM.entity.employeeEntity.Attendance;
import com.garmentsmanagement.GM.entity.employeeEntity.Employees;
import com.garmentsmanagement.GM.repository.EmployeeRepository.AttendanceRepo;
import com.garmentsmanagement.GM.repository.EmployeeRepository.EmployeeRepository;
import com.garmentsmanagement.GM.service.FileUploadService;
import com.garmentsmanagement.GM.service.employeeService.DeptService;
import com.garmentsmanagement.GM.service.employeeService.EmployeeService;
import com.garmentsmanagement.GM.utility.EmployeeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "emp/api")
@CrossOrigin("*")
public class EmployeeRestController {

    @Autowired
    DeptService deptService;

    @Autowired
    EmployeeUtility employeeUtility;
    @Autowired
    EmployeeService employeeService;

    @Autowired
    AttendanceRepo attendanceRepo;

    @Autowired
    EmployeeRepository employeeRepository;

    private String profileImg = "";

    FileUploadService fileUploadService;

//    Get All Employee
    @GetMapping(value = "/allemp")
    public List<Employees> getallEmp(){
        return employeeService.findAllEms();
    }


    //Create New Employee
    @PostMapping(value = "/save_emp")
    public void saveEmp(@RequestBody Employees emp){
        System.out.println(emp);
        emp.setEm_profileImg(profileImg);

        String name =  emp.getEm_name();
        String companyNmae =  "xxgm";
        String year = emp.getEm_joiningDate();
        int empNumer = employeeService.getTotalEmp();
        emp.setEm_employeeID(employeeUtility.generateEmpId(companyNmae,year,name,empNumer));
        employeeService.saveExployee(emp);
    }

    @GetMapping(value = "/emp_findby/{id}")
    public Optional<Employees> findbyidEmp(@PathVariable("id") long em_id){
       return employeeService.findEmpById(em_id);
    }




//    Enplouee Attandce
    @GetMapping("/attend/{id}")
    public Attendance empAtt(@PathVariable("id")String id){

        Attendance att = attendanceRepo.findEmpByEmpId(id, LocalDate.now());
        if (att == null){
            Employees emp = employeeRepository.findByEmid(id);
            Attendance attn = new Attendance();
            attn.setEmployees(new Employees(emp.getEm_id()));
            attn.setAtt_emIdg(id);
            attn.setAtt_startDate(LocalDate.now());
            attn.setAtt_starttime(LocalTime.now());
            Attendance attns = attendanceRepo.save(attn);
            return attns;

        }else {
            att.setAtt_endtDate(LocalDate.now());
            att.setAtt_endttime(LocalTime.now());
            att.setAtt_totalWorkHous((int) att.getAtt_starttime().until(LocalTime.now(), ChronoUnit.HOURS));
            Attendance attns = attendanceRepo.save(att);
            return attns;
        }

    }

    @PostMapping(value = {"/upload_emp_img"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void uploadOrderImg(@RequestPart("file") MultipartFile file) throws IOException {
        System.out.println(file);
        profileImg = fileUploadService.uploadImage(file);
    }



}
