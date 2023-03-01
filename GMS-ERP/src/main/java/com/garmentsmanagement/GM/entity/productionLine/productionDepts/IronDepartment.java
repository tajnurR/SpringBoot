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
public class IronDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long irD_id;
    private int irD_status;
    private LocalDate irD_startDate;
    private LocalTime irD_startTime;
    private LocalDate irD_deliverydate;
    private LocalTime irD_deliverytime;

    @ManyToOne
    @JoinColumn(name = "irD_od_fk")
    ClientOrder clientOrder;

    public IronDepartment(long irD_id) {
        this.irD_id = irD_id;
    }
}
