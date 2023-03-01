package com.garmentsmanagement.GM.arestController.restControllerEmployee;

import com.garmentsmanagement.GM.entity.employeeEntity.Employees;
import com.garmentsmanagement.GM.entity.productionLine.Inventory.ProductionR;
import com.garmentsmanagement.GM.entity.productionLine.InventoryPL;
import com.garmentsmanagement.GM.entity.productionLine.productionDepts.*;
import com.garmentsmanagement.GM.repository.EmployeeRepository.EmployeeRepository;
import com.garmentsmanagement.GM.repository.clientRepository.ICOrderRepository;
import com.garmentsmanagement.GM.repository.productionLine.*;
import com.garmentsmanagement.GM.repository.productionLine.InventoryRepo.ProductionRRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/pd_dept/api")
public class ProductionDeptController {

    @Autowired
    InventoryPlRepo inventoryPlRepo;

    @Autowired
    ProductionRequisitionRepo prRepo;

    @Autowired
    StitchingDepartmentRepo stitchingDepartmentRepo;

    @Autowired
    CuttingDepartmentRepo cuttingDepartmentRepo;

    @Autowired
    DyeingDepartmentRepo dyeingDepartmentRepo;

    @Autowired
    WashingDepartmentRepo washingDepartmentRepo;

    @Autowired
    QualityControlDepartmentRepo qualityControlDepartmentRepo;

    @Autowired
    IronDepartmentRepo ironDepartmentRepo;

    @Autowired
    PackagingDepartmentRepo packagingDepartmentRepo;

    @Autowired
    InspectionOrderShipmentRepo inspectionOrderShipmentRepo;

    @Autowired
    ICOrderRepository icOrderRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProductionRRepo productionRRepo;

    // Production Requsition Department

    //Get All Record (prD)
    @GetMapping("/get_all_prd")
    public List<ProductionRequisition> findprDAll(){
        return prRepo.findAll();
    }

    @GetMapping("/get_emp_bydept/{id}")
    public List<Employees> findAllEmp(@PathVariable("id")long deptId){
        return employeeRepository.findByDept(deptId);
    }

    @GetMapping("/get_emp_isass/{orid}")
    public List<ProductionR> findAllEmpIfAss(@PathVariable("orid")long orId){
        return productionRRepo.getactiveOrder(orId);
    }



    @PatchMapping("/prd_delivary/{orderId}")
    public void delievryOrder(@PathVariable("orderId")long orderId){
        InventoryPL invpr = inventoryPlRepo.findInvByOrderId(orderId);
        invpr.setInv_Delivary_status(2);
        inventoryPlRepo.save(invpr);

        ProductionRequisition prd = prRepo.findPrdByOrId(orderId);
        prd.setPdR_deliverytime(LocalTime.now());
        prd.setPdR_deliverydate(LocalDate.now());
        prd.setPdR_status(3); // means Order Delivary by dept
        prRepo.save(prd);
    }


//    Cutting Department
    @GetMapping("/get_all_cut")
    public List<CuttingDepartment> findCutDAll(){
    return cuttingDepartmentRepo.findAll();
    }

    @PatchMapping("/cut_delivary/{orderId}")
    public void delievryOrderCut(@PathVariable("orderId")long orderId){
        InventoryPL invpr = inventoryPlRepo.findInvByOrderId(orderId);
        invpr.setInv_Delivary_status(2);
        inventoryPlRepo.save(invpr);

        CuttingDepartment cut = cuttingDepartmentRepo.findPrdByOrId(orderId);
        cut.setCuD_deliverytime(LocalTime.now());
        cut.setCuD_deliverydate(LocalDate.now());
        cut.setCuD_status(2); // means Order Delivary by dept
        cuttingDepartmentRepo.save(cut);
    }

    //Stitching Department
    @GetMapping("/get_all_std")
    public List<StitchingDepartment> findStdDAll(){
    return stitchingDepartmentRepo.findAll();
}

    @PatchMapping("/std_delivary/{orderId}")
    public void delievryOrderStd(@PathVariable("orderId")long orderId){
        InventoryPL invpr = inventoryPlRepo.findInvByOrderId(orderId);
        invpr.setInv_Delivary_status(2);
        inventoryPlRepo.save(invpr);

        StitchingDepartment std = stitchingDepartmentRepo.findPrdByOrId(orderId);
        std.setStD_deliverytime(LocalTime.now());
        std.setStD_deliverydate(LocalDate.now());
        std.setStD_status(2); // means Order Delivary by dept
        stitchingDepartmentRepo.save(std);
    }

    // Dyeing Department
    @GetMapping("/get_all_dyd")
    public List<DyeingDepartment> finddydDAll(){
        return dyeingDepartmentRepo.findAll();
    }

    @PatchMapping("/dyd_delivary/{orderId}")
    public void delievryOrderDyd(@PathVariable("orderId")long orderId){
        InventoryPL invpr = inventoryPlRepo.findInvByOrderId(orderId);
        invpr.setInv_Delivary_status(2);
        inventoryPlRepo.save(invpr);

        DyeingDepartment dyd = dyeingDepartmentRepo.findPrdByOrId(orderId);
        dyd.setDyD_deliverytime(LocalTime.now());
        dyd.setDyD_deliverydate(LocalDate.now());
        dyd.setDyD_status(2); // means Order Delivary by dept
        dyeingDepartmentRepo.save(dyd);
    }

//    Washing Department
    @GetMapping("/get_all_wad")
    public List<WashingDepartment> findwadAll(){
    return washingDepartmentRepo.findAll();
}

    @PatchMapping("/wad_delivary/{orderId}")
    public void delievryOrderWad(@PathVariable("orderId")long orderId){
        InventoryPL invpr = inventoryPlRepo.findInvByOrderId(orderId);
        invpr.setInv_Delivary_status(2);
        inventoryPlRepo.save(invpr);

        WashingDepartment wad = washingDepartmentRepo.findPrdByOrId(orderId);
        wad.setWhD_deliverytime(LocalTime.now());
        wad.setWhD_deliverydate(LocalDate.now());
        wad.setWhD_states(2); // means Order Delivary by dept
        washingDepartmentRepo.save(wad);
    }

    //Quality ControlDepartment
    @GetMapping("/get_all_qc")
    public List<QualityControlDepartment> findQcAll(){
    return qualityControlDepartmentRepo.findAll();
}

    @PatchMapping("/qc_delivary/{orderId}")
    public void delievryOrderQc(@PathVariable("orderId")long orderId){
        InventoryPL invpr = inventoryPlRepo.findInvByOrderId(orderId);
        invpr.setInv_Delivary_status(2);
        inventoryPlRepo.save(invpr);

        QualityControlDepartment qc = qualityControlDepartmentRepo.findPrdByOrId(orderId);
        qc.setQcD_deliverytime(LocalTime.now());
        qc.setQcD_deliverydate(LocalDate.now());
        qc.setQcD_status(2); // means Order Delivary by dept
        qualityControlDepartmentRepo.save(qc);
    }

    //Iron Department
    @GetMapping("/get_all_ird")
    public List<IronDepartment> findIrdAll(){
        return ironDepartmentRepo.findAll();
    }

    @PatchMapping("/ird_delivary/{orderId}")
    public void delievryOrderIrd(@PathVariable("orderId")long orderId){
        InventoryPL invpr = inventoryPlRepo.findInvByOrderId(orderId);
        invpr.setInv_Delivary_status(2);
        inventoryPlRepo.save(invpr);

        IronDepartment ird = ironDepartmentRepo.findPrdByOrId(orderId);
        ird.setIrD_deliverytime(LocalTime.now());
        ird.setIrD_deliverydate(LocalDate.now());
        ird.setIrD_status(2); // means Order Delivary by dept
        ironDepartmentRepo.save(ird);
    }

    //Packaging Department
    @GetMapping("/get_all_pkg")
    public List<PackagingDepartment> findPkgAll(){
        return packagingDepartmentRepo.findAll();
    }

    @PatchMapping("/pkg_delivary/{orderId}")
    public void delievryOrderPkg(@PathVariable("orderId")long orderId){
        InventoryPL invpr = inventoryPlRepo.findInvByOrderId(orderId);
        invpr.setInv_Delivary_status(2);
        inventoryPlRepo.save(invpr);

        PackagingDepartment pkg = packagingDepartmentRepo.findPrdByOrId(orderId);
        pkg.setPkD_deliverytime(LocalTime.now());
        pkg.setPkD_deliverydate(LocalDate.now());
        pkg.setPkd_status(2); // means Order Delivary by dept
        packagingDepartmentRepo.save(pkg);
    }

    //Inspection Order Shipment
    @GetMapping("/get_all_ios")
    public List<InspectionOrderShipment> findIosAll(){
        return inspectionOrderShipmentRepo.findAll();
    }

    @PatchMapping("/ios_delivary/{orderId}")
    public void delievryOrderIos(@PathVariable("orderId")long orderId){
        InventoryPL invpr = inventoryPlRepo.findInvByOrderId(orderId);
        invpr.setInv_Delivary_status(2);
        inventoryPlRepo.save(invpr);

        InspectionOrderShipment ios = inspectionOrderShipmentRepo.findPrdByOrId(orderId);
        ios.setIos_deliverytime(LocalTime.now());
        ios.setIos_deliverydate(LocalDate.now());
        ios.setIos_status(2); // means Order Delivary by dept
        inspectionOrderShipmentRepo.save(ios);
    }
}
