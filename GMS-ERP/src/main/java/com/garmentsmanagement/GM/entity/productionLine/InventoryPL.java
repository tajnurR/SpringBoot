package com.garmentsmanagement.GM.entity.productionLine;

import com.garmentsmanagement.GM.entity.clientEntity.ClientOrder;
import com.garmentsmanagement.GM.entity.clientEntity.ClientRegistration;
import com.garmentsmanagement.GM.entity.productionLine.productionDepts.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Inventory_ProductLine")
@DynamicUpdate
public class InventoryPL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long inv_id;

    @Column
    private int inv_status;

    @Column
    private int inv_Delivary_status;

    @ManyToOne
    @JoinColumn(name = "order_id_fk", nullable = true)
    ClientOrder clientOrder;

    @ManyToOne
    @JoinColumn(name = "client_id_fk", nullable = true)
    ClientRegistration clientRegistration;

    @ManyToOne
    @JoinColumn(name = "pdR_id_fk", nullable = true)
    ProductionRequisition productionRequisition;

    @ManyToOne
    @JoinColumn(name = "stD_id_fk", nullable = true)
    StitchingDepartment stitchingDepartment;

    @ManyToOne
    @JoinColumn(name = "cuD_id_fk", nullable = true)
    CuttingDepartment cuttingDepartment;

    @ManyToOne
    @JoinColumn(name = "dyD_id_fk", nullable = true)
    DyeingDepartment dyeingDepartment;

    @ManyToOne
    @JoinColumn(name = "ios_id_fk", nullable = true)
    InspectionOrderShipment inspectionOrderShipment;

    @ManyToOne
    @JoinColumn(name = "irD_id_fk", nullable = true)
    IronDepartment ironDepartment;

    @ManyToOne
    @JoinColumn(name = "pkD_id_fk", nullable = true)
    PackagingDepartment packagingDepartment;

    @ManyToOne
    @JoinColumn(name = "qcD_id_fk", nullable = true)
    QualityControlDepartment qualityControlDepartment;

    @ManyToOne
    @JoinColumn(name = "waD_id_fk", nullable = true)
    WashingDepartment washingDepartment;


}
