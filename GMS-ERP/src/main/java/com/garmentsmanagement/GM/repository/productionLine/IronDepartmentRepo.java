package com.garmentsmanagement.GM.repository.productionLine;

import com.garmentsmanagement.GM.entity.productionLine.productionDepts.InspectionOrderShipment;
import com.garmentsmanagement.GM.entity.productionLine.productionDepts.IronDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IronDepartmentRepo extends JpaRepository<IronDepartment,Long> {

    @Query("select irD from IronDepartment irD where irD.clientOrder.coid = ?1")
    public IronDepartment findPrdByOrId(long orId);
}
