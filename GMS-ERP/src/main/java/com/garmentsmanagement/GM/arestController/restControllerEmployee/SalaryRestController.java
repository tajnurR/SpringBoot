package com.garmentsmanagement.GM.arestController.restControllerEmployee;

import com.garmentsmanagement.GM.entity.employeeEntity.Department;
import com.garmentsmanagement.GM.entity.employeeEntity.SalaryGrade;
import com.garmentsmanagement.GM.repository.EmployeeRepository.SalaryGradeRepo;
import com.garmentsmanagement.GM.service.employeeService.DeptService;
import com.garmentsmanagement.GM.utility.EmployeeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "emp/api")
@CrossOrigin("*")
public class SalaryRestController {

    @Autowired
    SalaryGradeRepo salaryGradeRepo;
    @Autowired
    EmployeeUtility employeeUtility;
    @Autowired
    DeptService deptService;

    @RequestMapping(value = "/get_salary_g")
    public List<SalaryGrade> findAllSalaryGrade(){
        return deptService.fildAllSalaryDrade();
    }

    @RequestMapping(value = "/save_salary_grade")
    public void createNewSalaryG(@RequestBody SalaryGrade sg){
        employeeUtility.setSalryExtension(sg);
        deptService.saveSalaryGrade(sg);
    }

    @DeleteMapping(value = "/delete_sg/{id}")
    public void deleteSG(@PathVariable("id") long sg_id){
        deptService.deleteSg(sg_id);
    }

    @GetMapping(value = "/find_id/{id}")
    public List<SalaryGrade> sgUpdate(@PathVariable long id){
        return deptService.findSgById(id);
    }

    @PutMapping(value = "/update_salary_grade")
    public void updateSalaryG(@RequestBody SalaryGrade sg){
        deptService.saveSalaryGrade(sg);
    }


}
