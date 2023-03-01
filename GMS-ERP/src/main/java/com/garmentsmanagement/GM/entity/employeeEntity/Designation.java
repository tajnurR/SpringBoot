package com.garmentsmanagement.GM.entity.employeeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "designation")
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long desgi_id;

    private String desgi_title;

    @ManyToOne
    @JoinColumn(name="dpet_id")
    Department department;

    @ManyToOne
    @JoinColumn(name="sg_id")
    SalaryGrade salaryGrade;


}
