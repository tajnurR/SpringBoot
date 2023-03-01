package com.garmentsmanagement.GM.arestController.restControllerEmployee;

import com.garmentsmanagement.GM.entity.employeeEntity.Department;
import com.garmentsmanagement.GM.service.employeeService.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("emp/api")
public class DepartmentRestController {
    @Autowired
    DeptService deptService;


    @RequestMapping(value = "/allDept")
    public List<Department> depAll(){
        return deptService.findAllDept();
    }
    @PostMapping("/savedep")
    public void depSave(@RequestBody Department dep){
        deptService.saveDep(dep);
    }
    @DeleteMapping(value = "/delete_dep/{id}")
    public void depDelete(@PathVariable("id") long dep_id){
        deptService.deleteDep(dep_id);
    }

    @GetMapping(value = "/find_iddep/{id}")
    public List<Department> depFindById(@PathVariable("id") long dep_id){

        return deptService.findbyidDep(dep_id);
    }
    @PutMapping(value = "/update_dep")
    public void depupdate(@RequestBody Department dep){
        deptService.saveDep(dep);
    }





}
