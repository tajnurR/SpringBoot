package com.garmentsmanagement.GM.repository.EmployeeRepository;

import com.garmentsmanagement.GM.entity.employeeEntity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AttendanceRepo extends JpaRepository<Attendance, Long> {

    @Query("select empa from Attendance empa where empa.att_emIdg = ?1 and empa.att_startDate = ?2")
    public Attendance findEmpByEmpId(String empIdg, LocalDate currentDate);
}
