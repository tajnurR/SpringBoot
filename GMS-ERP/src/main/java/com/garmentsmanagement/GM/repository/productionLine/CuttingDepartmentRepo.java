package com.garmentsmanagement.GM.repository.productionLine;


import com.garmentsmanagement.GM.entity.productionLine.productionDepts.CuttingDepartment;
import com.garmentsmanagement.GM.entity.productionLine.productionDepts.ProductionRequisition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CuttingDepartmentRepo  extends JpaRepository<CuttingDepartment, Long> {

    @Query("select cut from CuttingDepartment cut where cut.clientOrder.coid = ?1")
    public CuttingDepartment findPrdByOrId(long orId);
}
