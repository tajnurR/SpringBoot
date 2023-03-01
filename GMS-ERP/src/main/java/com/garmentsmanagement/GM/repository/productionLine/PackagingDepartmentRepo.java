package com.garmentsmanagement.GM.repository.productionLine;

import com.garmentsmanagement.GM.entity.productionLine.productionDepts.IronDepartment;
import com.garmentsmanagement.GM.entity.productionLine.productionDepts.PackagingDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PackagingDepartmentRepo extends JpaRepository<PackagingDepartment,Long> {

    @Query("select pkg from PackagingDepartment pkg where pkg.clientOrder.coid = ?1")
    public PackagingDepartment findPrdByOrId(long orId);
}
