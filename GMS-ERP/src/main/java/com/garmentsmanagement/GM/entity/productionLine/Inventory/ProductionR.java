package com.garmentsmanagement.GM.entity.productionLine.Inventory;

import com.garmentsmanagement.GM.entity.clientEntity.ClientOrder;
import com.garmentsmanagement.GM.entity.employeeEntity.Employees;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Data
@Table(name = "prdInv")
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class ProductionR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long inv_id;

    @Column
    private int inv_status;

    @ManyToOne
    @JoinColumn(name="invEmFk")
    Employees employees;

    @ManyToOne
    @JoinColumn(name="invOrdFk")
    ClientOrder clientOrder;

}
