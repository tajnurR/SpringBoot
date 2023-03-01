package com.garmentsmanagement.GM.repository.EmployeeRepository;

import com.garmentsmanagement.GM.entity.employeeEntity.StartAttend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StartAttendRepo extends JpaRepository<StartAttend, Long> {

    @Query("select st from StartAttend st where st.att_emId = ?1 and st.startDate = ?2")
    public List<StartAttend> findAttendById(String empId, LocalDate currentDate);
//
//    @Query("update StartAttend at set at.leaveDate = ?1, at.leaveTime = ?2, at.em_leave = true where at.em_id = ?3")
//    public void updateAtt(LocalDate endDate, LocalTime endTime, Long id);
//

}
