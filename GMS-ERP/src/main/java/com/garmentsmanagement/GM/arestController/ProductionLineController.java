package com.garmentsmanagement.GM.arestController;

import com.garmentsmanagement.GM.entity.clientEntity.ClientOrder;
import com.garmentsmanagement.GM.entity.productionLine.InventoryPL;
import com.garmentsmanagement.GM.entity.productionLine.productionDepts.*;
import com.garmentsmanagement.GM.repository.clientRepository.ICOrderRepository;
import com.garmentsmanagement.GM.repository.clientRepository.IClientRepository;
import com.garmentsmanagement.GM.repository.productionLine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/pd_line/api")
public class ProductionLineController {

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




    @PatchMapping("/depl_d/{ord_id}")
    public void deployDeprtment(@PathVariable("ord_id")long ordId) throws InterruptedException {
//        long inv_id = invp.getInv_id();
        long orderid = ordId;
        InventoryPL invList = inventoryPlRepo.findInvByOrderId(orderid);

            if (invList.getProductionRequisition() == null) {
                ProductionRequisition prd = new ProductionRequisition();
                prd.setPdR_startDate(LocalDate.now());
                prd.setPdR_startTime(LocalTime.now());
                prd.setPdR_status(1);
                prd.setClientOrder(new ClientOrder(orderid));
                ProductionRequisition pr = prRepo.save(prd);
                Long prx = pr.getPdR_id();
                InventoryPL prd_inv1 = inventoryPlRepo.findInvByOrderId(orderid);
                prd_inv1.setInv_Delivary_status(1);
                prd_inv1.setInv_status(2);
                prd_inv1.setProductionRequisition(new ProductionRequisition(prx));
                inventoryPlRepo.save(prd_inv1);
//              Update Oder status
                ClientOrder oderUp = icOrderRepository.findById(orderid).get();
                oderUp.setOrderStatus(2);
                icOrderRepository.save(oderUp);

            } else if (invList.getCuttingDepartment() == null) {
                CuttingDepartment cud = new CuttingDepartment();
                cud.setCuD_startDate(LocalDate.now());
                cud.setCuD_startTime(LocalTime.now());
                cud.setCuD_status(1);
                cud.setClientOrder(new ClientOrder(orderid));
                cud = cuttingDepartmentRepo.save(cud);
                Long cudx = cud.getCuD_id();
                InventoryPL prd_inv = inventoryPlRepo.findInvByOrderId(orderid);
                prd_inv.setInv_Delivary_status(1);
                prd_inv.setInv_status(3);
                prd_inv.setCuttingDepartment(new CuttingDepartment(cudx));
                inventoryPlRepo.save(prd_inv);

//                Chnage Deprartment table status
                ProductionRequisition prd = prRepo.findPrdByOrId(orderid);
                prd.setPdR_status(3);
                prRepo.save(prd);
            } else if (invList.getStitchingDepartment() == null) {
                StitchingDepartment std = new StitchingDepartment();
                std.setStD_startDate(LocalDate.now());
                std.setStD_startTime(LocalTime.now());
                std.setStD_status(1);
                std.setClientOrder(new ClientOrder(orderid));
                std = stitchingDepartmentRepo.save(std);
                Long stdx = std.getStD_id();
                InventoryPL prd_inv = inventoryPlRepo.findInvByOrderId(orderid);
                prd_inv.setInv_Delivary_status(1);
                prd_inv.setInv_status(4);
                prd_inv.setStitchingDepartment(new StitchingDepartment(stdx));
                inventoryPlRepo.save(prd_inv);

                //Chnage Deprartment table status
                CuttingDepartment cut = cuttingDepartmentRepo.findPrdByOrId(orderid);
                cut.setCuD_status(3);
                cuttingDepartmentRepo.save(cut);

            } else if (invList.getDyeingDepartment() == null) {
                DyeingDepartment dyd = new DyeingDepartment();
                dyd.setDyD_startDate(LocalDate.now());
                dyd.setDyD_startTime(LocalTime.now());
                dyd.setDyD_status(1);
                dyd.setClientOrder(new ClientOrder(orderid));
                dyd = dyeingDepartmentRepo.save(dyd);
                Long dydx = dyd.getDyD_id();
                InventoryPL prd_inv = inventoryPlRepo.findInvByOrderId(orderid);
                prd_inv.setInv_Delivary_status(1);
                prd_inv.setInv_status(5);
                prd_inv.setDyeingDepartment(new DyeingDepartment(dydx));
                inventoryPlRepo.save(prd_inv);

                //Chnage Deprartment table status
                StitchingDepartment std = stitchingDepartmentRepo.findPrdByOrId(orderid);
                std.setStD_status(3);
                stitchingDepartmentRepo.save(std);

            } else if (invList.getWashingDepartment() == null) {
                WashingDepartment wad = new WashingDepartment();
                wad.setWhD_startDate(LocalDate.now());
                wad.setWhD_startTime(LocalTime.now());
                wad.setWhD_states(1);
                wad.setClientOrder(new ClientOrder(orderid));
                wad = washingDepartmentRepo.save(wad);
                Long wadx = wad.getWhD_id();
                InventoryPL prd_inv = inventoryPlRepo.findInvByOrderId(orderid);
                prd_inv.setInv_Delivary_status(1);
                prd_inv.setInv_status(6);
                prd_inv.setWashingDepartment(new WashingDepartment(wadx));
                inventoryPlRepo.save(prd_inv);

                //Chnage Deprartment table status
                DyeingDepartment dyd = dyeingDepartmentRepo.findPrdByOrId(orderid);
                dyd.setDyD_status(3);
                dyeingDepartmentRepo.save(dyd);

            } else if (invList.getQualityControlDepartment() == null) {
                QualityControlDepartment qcd = new QualityControlDepartment();
                qcd.setQcD_startDate(LocalDate.now());
                qcd.setQcD_startTime(LocalTime.now());
                qcd.setQcD_status(1);
                qcd.setClientOrder(new ClientOrder(orderid));
                qcd = qualityControlDepartmentRepo.save(qcd);
                Long qcdx = qcd.getQcD_id();
                InventoryPL prd_inv = inventoryPlRepo.findInvByOrderId(orderid);
                prd_inv.setInv_Delivary_status(1);
                prd_inv.setInv_status(7);
                prd_inv.setQualityControlDepartment(new QualityControlDepartment(qcdx));
                inventoryPlRepo.save(prd_inv);

                //Chnage Deprartment table status
                WashingDepartment wd = washingDepartmentRepo.findPrdByOrId(orderid);
                wd.setWhD_states(3);
                washingDepartmentRepo.save(wd);

            } else if (invList.getIronDepartment() == null) {
                IronDepartment ird = new IronDepartment();
                ird.setIrD_startDate(LocalDate.now());
                ird.setIrD_startTime(LocalTime.now());
                ird.setIrD_status(1);
                ird.setClientOrder(new ClientOrder(orderid));
                ird = ironDepartmentRepo.save(ird);
                Long irdx = ird.getIrD_id();
                InventoryPL prd_inv = inventoryPlRepo.findInvByOrderId(orderid);
                prd_inv.setInv_Delivary_status(1);
                prd_inv.setInv_status(8);
                prd_inv.setIronDepartment(new IronDepartment(irdx));
                inventoryPlRepo.save(prd_inv);

                //Chnage Deprartment table status
                QualityControlDepartment qc = qualityControlDepartmentRepo.findPrdByOrId(orderid);
                qc.setQcD_status(3);
                qualityControlDepartmentRepo.save(qc);

            } else if (invList.getPackagingDepartment() == null) {
                PackagingDepartment pkd = new PackagingDepartment();
                pkd.setPkD_startDate(LocalDate.now());
                pkd.setPkD_startTime(LocalTime.now());
                pkd.setPkd_status(1);
                pkd.setClientOrder(new ClientOrder(orderid));
                pkd = packagingDepartmentRepo.save(pkd);
                Long pkdx = pkd.getPkD_id();
                InventoryPL prd_inv = inventoryPlRepo.findInvByOrderId(orderid);
                prd_inv.setInv_Delivary_status(1);
                prd_inv.setInv_status(9);
                prd_inv.setPackagingDepartment(new PackagingDepartment(pkdx));
                inventoryPlRepo.save(prd_inv);

                //Chnage Deprartment table status
                IronDepartment ir = ironDepartmentRepo.findPrdByOrId(orderid);
                ir.setIrD_status(3);
                ironDepartmentRepo.save(ir);

            } else if (invList.getInspectionOrderShipment() == null) {
                InspectionOrderShipment isd = new InspectionOrderShipment();
                isd.setIos_startDate(LocalDate.now());
                isd.setIos_startTime(LocalTime.now());
                isd.setIos_status(1);
                isd.setClientOrder(new ClientOrder(orderid));
                isd = inspectionOrderShipmentRepo.save(isd);
                Long isdx = isd.getIos_id();
                InventoryPL prd_inv = inventoryPlRepo.findInvByOrderId(orderid);
                prd_inv.setInv_Delivary_status(3);
                prd_inv.setInv_status(10);
                prd_inv.setInspectionOrderShipment(new InspectionOrderShipment(isdx));
                inventoryPlRepo.save(prd_inv);

                //Chnage Deprartment table status
                PackagingDepartment pkg = packagingDepartmentRepo.findPrdByOrId(orderid);
                pkg.setPkd_status(3);
                packagingDepartmentRepo.save(pkg);
            } else if(invList.getInv_status() == 10){
                invList.setInv_Delivary_status(3);
                inventoryPlRepo.save(invList);


                ClientOrder co = icOrderRepository.findByOrderId(orderid);
                co.setOrderStatus(4);
                icOrderRepository.save(co);
            }

        }

//    }

    @GetMapping("/get_invp")
    public List<InventoryPL> getInvp(){
        return inventoryPlRepo.findAll();
    }

    @RequestMapping("/all_order")
    public List<ClientOrder> getAllOder(){
        return icOrderRepository.findAll();
    }
}
