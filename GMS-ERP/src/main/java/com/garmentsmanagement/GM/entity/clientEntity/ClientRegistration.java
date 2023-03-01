package com.garmentsmanagement.GM.entity.clientEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ClientInformation")
public class ClientRegistration {

    //01
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    //02
    @Column //Client Name Done
    private String client_name;
    //04
    @Column //Done
    private String client_phone;
    //06
    @Column //Done
    private String client_gender;
    //07
    @Column //Done
    private String client_dob;
    //09
    @Column //Done
    private String client_address;
    //10
    @Column //Done
    private String client_email;
    //11
    @Column //Done
    private String client_password;

    @Column //Done
    private String client_country;

    @Column
    private String client_image;



}
