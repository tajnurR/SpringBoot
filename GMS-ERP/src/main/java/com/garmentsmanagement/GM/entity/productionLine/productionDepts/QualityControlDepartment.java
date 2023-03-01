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
public class QualityControlDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long qcD_id;
    private int qcD_status;
    private LocalDate qcD_startDate;
    private LocalTime qcD_startTime;
    private LocalDate qcD_deliverydate;
    private LocalTime qcD_deliverytime;

    @ManyToOne
    @JoinColumn(name = "qcD_od_fk")
    ClientOrder clientOrder;

    public QualityControlDepartment(long qcD_id) {
        this.qcD_id = qcD_id;
    }
}
