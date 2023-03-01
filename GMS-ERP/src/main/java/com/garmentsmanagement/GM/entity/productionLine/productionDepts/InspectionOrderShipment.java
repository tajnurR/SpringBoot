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
public class InspectionOrderShipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ios_id;
    private int ios_status;
    private LocalDate ios_startDate;
    private LocalTime ios_startTime;
    private LocalDate ios_deliverydate;
    private LocalTime ios_deliverytime;

    @ManyToOne
    @JoinColumn(name = "ios_od_fk")
    ClientOrder clientOrder;
    public InspectionOrderShipment(long ios_id) {
        this.ios_id = ios_id;
    }
}
