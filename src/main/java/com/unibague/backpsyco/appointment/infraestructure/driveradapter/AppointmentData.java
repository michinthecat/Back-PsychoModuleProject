package com.unibague.backpsyco.appointment.infraestructure.driveradapter;

import com.unibague.backpsyco.patient.infraestructure.driveradapter.PatientData;
import com.unibague.backpsyco.psychologist.infraestructure.driveradapter.PsychologistData;
import com.unibague.backpsyco.service.infraestructure.driveradapter.ServiceData;
import com.unibague.backpsyco.state.infraestructure.driveradapter.StateData;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Table(name = "appointments")
@Data
public class AppointmentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "serviceid", nullable = false)
    private ServiceData service;

    @ManyToOne
    @JoinColumn(name = "psychologistid", nullable = false)
    private PsychologistData psychologist;

    @ManyToOne
    @JoinColumn(name = "patientId", nullable = false)
    private PatientData patient;

    @ManyToOne
    @JoinColumn(name = "stateid", nullable = false)
    private StateData state;
}