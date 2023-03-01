package com.garmentsmanagement.GM.utility;

import com.garmentsmanagement.GM.entity.employeeEntity.SalaryGrade;
import com.garmentsmanagement.GM.entity.employeeEntity.StartAttend;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class EmployeeUtility {

    public void setSalryExtension(SalaryGrade sg){
        long basicSalry = sg.getBasicSalary();
        long houseR = (basicSalry/100)*30;
        long healthR = (basicSalry/100)*20;
        sg.setHouseRant(houseR);
        sg.setHealthRant(healthR);
        sg.setTotalSalary(basicSalry+houseR+healthR);
    }

    public String generateEmpId(String dept, String year, String grade, int totalEmp){
        String[] yearx = year.split("-");
        year = yearx[0];

        String empID = dept+"-"+year+"-"+grade+"-"+(1000+totalEmp);

        return empID;
    }

    public void attendAccpected(String id){
        StartAttend st = new StartAttend();
        st.setEm_attend(true);
        st.setStartDate(LocalDate.now());
        st.setStartTime(LocalTime.now());
        st.setAtt_emId(id);
    }
}
