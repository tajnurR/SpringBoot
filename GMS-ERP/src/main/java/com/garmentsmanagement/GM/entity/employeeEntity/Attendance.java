package com.garmentsmanagement.GM.entity.employeeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long att_id;

    @Column
    private String att_emIdg;
    @Column
    private boolean att_status = false;
    @Column
    public LocalDate att_startDate = LocalDate.now();
    @Column
    public LocalTime att_starttime = LocalTime.now();
    @Column
    public LocalDate att_endtDate = LocalDate.now();
    @Column
    public LocalTime att_endttime = LocalTime.now();
    @Column
    private int att_totalWorkHous;


    @ManyToOne
    @JoinColumn(name="empID_pk")
    Employees employees;
}
