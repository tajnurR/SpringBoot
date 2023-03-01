package com.garmentsmanagement.GM.entity.employeeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "saleygrade")
public class SalaryGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sg_id;
    @Column(length = 20)
    private String sg_name;
    private long basicSalary;
    private long totalSalary;
    private long houseRant;
    private long healthRant;

    public SalaryGrade(Long sg_id) {
        this.sg_id = sg_id;
    }
}
