package com.garmentsmanagement.GM.service.employeeService;

import com.garmentsmanagement.GM.entity.employeeEntity.EndtAttendance;
import com.garmentsmanagement.GM.entity.employeeEntity.StartAttend;
import com.garmentsmanagement.GM.entity.employeeEntity.Employees;
import com.garmentsmanagement.GM.entity.employeeEntity.SalaryGrade;
import com.garmentsmanagement.GM.entity.employeeEntity.Designation;
import com.garmentsmanagement.GM.repository.EmployeeRepository.DesignationRepo;
import com.garmentsmanagement.GM.repository.EmployeeRepository.EndAttendRepo;
import com.garmentsmanagement.GM.repository.EmployeeRepository.StartAttendRepo;
import com.garmentsmanagement.GM.repository.EmployeeRepository.EmployeeRepository;
import com.garmentsmanagement.GM.repository.EmployeeRepository.SalaryGradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    SalaryGradeRepo sgRepo;

    @Autowired
    DesignationRepo desigRepo;

    @Autowired
    StartAttendRepo stAttRepo;

    @Autowired
    EndAttendRepo endAttendRepo;

    public Optional<Employees> findEmpById(long id){
        return employeeRepository.findById(id);
    }

    public List<Employees> findAllEms(){
        return employeeRepository.findAll();
    }

//    public List<Employees> findEmplyByEmid(String id){
//        return employeeRepository.findByEmid(id);
//    }

//    Save Emplyee
    public void saveExployee(Employees hre){
        employeeRepository.save(hre);
    }

//    Get All Grade
    public List<SalaryGrade> getAllGrade()
    {return sgRepo.findAll();}

//    Find Grade by id
    public SalaryGrade findGredeById(long sg_kkid){return sgRepo.findById(sg_kkid).get();}

//    Delete Grade
    public void deleteGrade(long sg_id){sgRepo.deleteById(sg_id);}

//    Find Designation By Dept Foren key
    public List<Designation> findDesigByDept(long id){return desigRepo.findByDesigId(id);}

//    Count How many emplyee register
    public int getTotalEmp(){
        return employeeRepository.countRow();
    }

   public List<StartAttend> findStartData(String id){
        LocalDate x = LocalDate.now();
        return stAttRepo.findAttendById(id, x);
   }

    public List<EndtAttendance> findEndData(long id){
        LocalDate x = LocalDate.now();
        return endAttendRepo.findEndAttendById(id, x);
    }

    public List<EndtAttendance> findEndAtByEmpIdImp(String id){
        LocalDate x = LocalDate.now();
        return endAttendRepo.findEndAtByEmpId(id, x);
    }


    public void saveStartAtt(StartAttend sta){
        stAttRepo.save(sta);
   }

   public void saveStartAtt(EndtAttendance Eta){
       endAttendRepo.save(Eta);
    }



}
