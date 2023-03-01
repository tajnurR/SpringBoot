package com.garmentsmanagement.GM.repository.EmployeeRepository;

import com.garmentsmanagement.GM.entity.employeeEntity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignationRepo extends JpaRepository<Designation, Long> {

    @Query("select dg from Designation dg inner JOIN dg.department dp where dp.dep_id = ?1")
    public List<Designation> findByDesigId(long id);
}
