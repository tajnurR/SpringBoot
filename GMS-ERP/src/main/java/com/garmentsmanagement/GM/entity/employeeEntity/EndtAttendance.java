package com.garmentsmanagement.GM.entity.employeeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endAttdend")
public class EndtAttendance {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private boolean em_leave = false;

    @Column
    public LocalDate leaveDate = LocalDate.now();

    @Column
    public LocalTime leaveTime = LocalTime.now();

    @Column
    private long totalWorkHous;

    @Column
    private String em_idEnd;

    @OneToOne
    @JoinColumn(name="startAtt_pk")
    StartAttend startAttend;


}
