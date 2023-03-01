package com.garmentsmanagement.GM.repository.EmployeeRepository;

import com.garmentsmanagement.GM.entity.employeeEntity.EndtAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EndAttendRepo extends JpaRepository<EndtAttendance, Long> {

    @Query("select edst from EndtAttendance edst where edst.startAttend.em_id = ?1 and edst.leaveDate = ?2")
    public List<EndtAttendance> findEndAttendById(Long empId, LocalDate currentDate);

    @Query("select edat from EndtAttendance edat where edat.em_idEnd = ?1 and edat.leaveDate = ?2")
    public List<EndtAttendance> findEndAtByEmpId(String id, LocalDate dt);
}
