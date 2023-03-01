package com.garmentsmanagement.GM.entity.clientEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ClientOrderList")
@DynamicUpdate
public class ClientOrder {
    //01
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long coid; //Client Order ID will Generate like COUNTRY-YEAR-Serial = USA-23-07

    @Column
    private String oder_title;
    @Column
    private String order_d_type;
    @Column
    private String oder_size;
    @Column
    private String oder_color;
    @Column
    private String oder_s_img;


    @Column(length = 25)
    private long orderStatus;
    // Status 1 = order placed - waiting for Admin Approve
    // Status 2 = Order Approve for sample - in Client list will show Order Approved;


    @ManyToOne
    @JoinColumn(name = "cid_fk")
    ClientRegistration coCid;

    public ClientOrder(long coid) {
        this.coid = coid;
    }
}
