package com.garmentsmanagement.GM.repository.productionLine;

import com.garmentsmanagement.GM.entity.productionLine.productionDepts.QualityControlDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QualityControlDepartmentRepo extends JpaRepository<QualityControlDepartment,Long> {

    @Query("select qc from QualityControlDepartment qc where qc.clientOrder.coid = ?1")
    public QualityControlDepartment findPrdByOrId(long orId);
}
