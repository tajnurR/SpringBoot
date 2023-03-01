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
public class DyeingDepartment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dyD_id;
    private int dyD_status;
    private LocalDate dyD_startDate;
    private LocalTime dyD_startTime;
    private LocalDate dyD_deliverydate;
    private LocalTime dyD_deliverytime;

    @ManyToOne
    @JoinColumn(name = "dyD_od_fk")
    ClientOrder clientOrder;

    public DyeingDepartment(long dyD_id) {
        this.dyD_id = dyD_id;
    }
}