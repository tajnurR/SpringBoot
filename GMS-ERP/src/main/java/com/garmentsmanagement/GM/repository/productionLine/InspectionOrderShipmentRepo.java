package com.garmentsmanagement.GM.repository.productionLine;

import com.garmentsmanagement.GM.entity.productionLine.productionDepts.DyeingDepartment;
import com.garmentsmanagement.GM.entity.productionLine.productionDepts.InspectionOrderShipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionOrderShipmentRepo extends JpaRepository<InspectionOrderShipment,Long> {

    @Query("select ios from InspectionOrderShipment ios where ios.clientOrder.coid = ?1")
    public InspectionOrderShipment findPrdByOrId(long orId);
}
