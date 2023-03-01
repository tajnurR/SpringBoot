package com.garmentsmanagement.GM.repository.productionLine;

import com.garmentsmanagement.GM.entity.productionLine.productionDepts.StitchingDepartment;
import com.garmentsmanagement.GM.entity.productionLine.productionDepts.WashingDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WashingDepartmentRepo extends JpaRepository<WashingDepartment,Long> {

    @Query("select wd from WashingDepartment wd where wd.clientOrder.coid = ?1")
    public WashingDepartment findPrdByOrId(long orId);
}
