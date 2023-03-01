package com.garmentsmanagement.GM.repository.EmployeeRepository;

import com.garmentsmanagement.GM.entity.employeeEntity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long> {

    @Query("select emp from Employees emp where emp.department.dep_id = ?1")
    public List<Employees> findByDept(long deptId);

    @Query("select count(em.em_id) from Employees em")
    public int countRow();

    @Query("select em from Employees em where em.em_employeeID = ?1")
    public Employees findByEmid(String emid);

}
