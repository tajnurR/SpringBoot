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
public class PackagingDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pkD_id;
    private int pkd_status;
    private LocalDate pkD_startDate;
    private LocalTime pkD_startTime;
    private LocalDate pkD_deliverydate;
    private LocalTime pkD_deliverytime;

    @ManyToOne
    @JoinColumn(name = "pkD_od_fk")
    ClientOrder clientOrder;

    public PackagingDepartment(long pkD_id) {
        this.pkD_id = pkD_id;
    }
}
