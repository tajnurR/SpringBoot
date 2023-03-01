package com.garmentsmanagement.GM.entity.employeeEntity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long em_id;
    @Column
    private String em_employeeID;
    @Column
    private String em_name;
    @Column
    private String em_fatherName;
    @Column
    private String em_nid;
    @Column
    private String em_phone;
    @Column
    private String em_gender;

    @Column
    private String em_dob;

    @Column
    private String em_relationshipStatus;

    @Column
    private String em_spouseName;

    @Column
    private String em_spouseNID;

    @Column
    private String em_PreviousCompany;

    @Column
    private String em_profileImg;

    @Column
    private String em_joiningDate;

    @Column
    private String em_resentAddress;

    @Column
    private String em_permanentAddress;

    @Column
    private String em_email;

    @Column
    private String em_password;



    @ManyToOne
    @JoinColumn(name="department_fk")
    Department department;

    @ManyToOne
    @JoinColumn(name="designation_fk")
    Designation designation;


    public Employees(long em_id) {
        this.em_id = em_id;
    }
}
