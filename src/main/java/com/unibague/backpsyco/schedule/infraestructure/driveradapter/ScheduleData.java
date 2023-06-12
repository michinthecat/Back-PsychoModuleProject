package com.unibague.backpsyco.schedule.infraestructure.driveradapter;

import com.unibague.backpsyco.psychologist.infraestructure.driveradapter.PsychologistData;
import com.unibague.backpsyco.state.infraestructure.driveradapter.StateData;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "schedules",
        uniqueConstraints = @UniqueConstraint(columnNames = {"date", "time", "psychologist_id"}))
@Data
public class ScheduleData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "psychologist_id", nullable = false)
    private PsychologistData psychologist;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stateid", nullable = false)
    private StateData state;
}