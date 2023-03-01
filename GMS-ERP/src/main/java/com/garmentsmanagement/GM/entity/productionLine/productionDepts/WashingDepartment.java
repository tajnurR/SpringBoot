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
public class WashingDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long whD_id;
    private int whD_states;
    private LocalDate whD_startDate;
    private LocalTime whD_startTime;
    private LocalDate whD_deliverydate;
    private LocalTime whD_deliverytime;

    @ManyToOne
    @JoinColumn(name = "whD_od_fk")
    ClientOrder clientOrder;

    public WashingDepartment(long whD_id) {
        this.whD_id = whD_id;
    }
}
