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
public class CuttingDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cuD_id;
    private int cuD_status;
    private LocalDate cuD_startDate;
    private LocalTime cuD_startTime;
    private LocalDate cuD_deliverydate;
    private LocalTime cuD_deliverytime;

    @ManyToOne
    @JoinColumn(name = "cuD_od_fk")
    ClientOrder clientOrder;

    public CuttingDepartment(long cuD_id) {
        this.cuD_id = cuD_id;
    }
}
