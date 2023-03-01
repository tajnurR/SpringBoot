package com.garmentsmanagement.GM.entity.productionLine.productionDepts;

import com.garmentsmanagement.GM.entity.clientEntity.ClientOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class ProductionRequisition {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pdR_id;
    private int pdR_status;
    private LocalDate pdR_startDate;
    private LocalTime pdR_startTime;
    private LocalDate pdR_deliverydate;
    private LocalTime pdR_deliverytime;

    public ProductionRequisition(long pdR_id) {
        this.pdR_id = pdR_id;
    }

    @ManyToOne
    @JoinColumn(name ="prd_id_fk")
    ClientOrder clientOrder;


}
