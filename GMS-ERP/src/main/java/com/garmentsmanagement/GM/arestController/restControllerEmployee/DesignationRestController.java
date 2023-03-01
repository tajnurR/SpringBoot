package com.garmentsmanagement.GM.arestController.restControllerEmployee;

import com.garmentsmanagement.GM.entity.employeeEntity.Department;
import com.garmentsmanagement.GM.entity.employeeEntity.Designation;
import com.garmentsmanagement.GM.repository.EmployeeRepository.DesignationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("emp/api")
public class DesignationRestController {

    @Autowired
    DesignationRepo designationRepo;


    @GetMapping(value = "/allDesig")
    public List<Designation> desigAll(){
        return designationRepo.findAll();

    }
    @PostMapping("/savedesig")
    public void desiSave(@RequestBody Designation desi){
        System.out.println(desi);
        designationRepo.save(desi);
    }
    @DeleteMapping(value = "/delete_desi/{id}")
    public void desiDelete(@PathVariable("id") long desgi_id){
      designationRepo.deleteById(desgi_id);
    }

    @GetMapping(value = "/find_iddesi/{id}")
    public Optional<Designation> desiFindById(@PathVariable("id") long desgi_id){
       return designationRepo.findById(desgi_id);
    }
    @PutMapping(value = "/update_desi")
    public void desiupdate(@RequestBody Designation desi){
        designationRepo.save(desi);
    }


}
