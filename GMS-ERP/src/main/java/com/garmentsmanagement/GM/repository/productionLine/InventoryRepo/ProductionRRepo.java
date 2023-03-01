package com.garmentsmanagement.GM.repository.productionLine.InventoryRepo;

import com.garmentsmanagement.GM.entity.productionLine.Inventory.ProductionR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionRRepo extends JpaRepository<ProductionR, Long> {

    @Query("select pr from ProductionR pr where pr.clientOrder.coid = ?1")
    public List<ProductionR> getactiveOrder(long orid);
}
