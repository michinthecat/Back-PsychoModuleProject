package com.unibague.backpsyco.schedule.infraestructure.driveradapter;

import com.unibague.backpsyco.psychologist.infraestructure.driveradapter.PsychologistData;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "schedules")
@Data
public class ScheduleData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @ManyToMany(mappedBy = "schedules")
    private Set<PsychologistData> psychologists;
}