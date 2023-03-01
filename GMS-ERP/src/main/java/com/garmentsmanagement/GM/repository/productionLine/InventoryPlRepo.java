package com.garmentsmanagement.GM.repository.productionLine;

import com.garmentsmanagement.GM.entity.productionLine.InventoryPL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryPlRepo extends JpaRepository<InventoryPL, Long> {

    @Query("select inv from InventoryPL inv where inv.clientOrder.coid = ?1")
    public InventoryPL findInvByOrderId(long orId);
}
