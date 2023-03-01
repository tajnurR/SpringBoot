package com.garmentsmanagement.GM.repository.productionLine;

import com.garmentsmanagement.GM.entity.productionLine.productionDepts.CuttingDepartment;
import com.garmentsmanagement.GM.entity.productionLine.productionDepts.DyeingDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DyeingDepartmentRepo extends JpaRepository<DyeingDepartment,Long> {

    @Query("select dyd from DyeingDepartment dyd where dyd.clientOrder.coid = ?1")
    public DyeingDepartment findPrdByOrId(long orId);
}
