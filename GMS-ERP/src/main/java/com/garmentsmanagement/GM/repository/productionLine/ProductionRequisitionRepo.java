package com.garmentsmanagement.GM.repository.productionLine;

import com.garmentsmanagement.GM.entity.productionLine.InventoryPL;
import com.garmentsmanagement.GM.entity.productionLine.productionDepts.ProductionRequisition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionRequisitionRepo extends JpaRepository<ProductionRequisition, Long> {

    @Query("select prd from ProductionRequisition prd where prd.clientOrder.coid = ?1")
    public ProductionRequisition findPrdByOrId(long orId);
}
