package com.garmentsmanagement.GM.repository.productionLine;

import com.garmentsmanagement.GM.entity.productionLine.productionDepts.QualityControlDepartment;
import com.garmentsmanagement.GM.entity.productionLine.productionDepts.StitchingDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StitchingDepartmentRepo extends JpaRepository<StitchingDepartment,Long> {

    @Query("select std from StitchingDepartment std where std.clientOrder.coid = ?1")
    public StitchingDepartment findPrdByOrId(long orId);
}
