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
public class StitchingDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stD_id;
    private int stD_status;
    private LocalDate stD_startDate;
    private LocalTime stD_startTime;
    private LocalDate stD_deliverydate;
    private LocalTime stD_deliverytime;

    @ManyToOne
    @JoinColumn(name = "stD_od_fk")
    ClientOrder clientOrder;

    public StitchingDepartment(long stD_id) {
        this.stD_id = stD_id;
    }
}
