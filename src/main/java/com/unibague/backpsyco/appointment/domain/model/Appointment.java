package com.unibague.backpsyco.appointment.domain.model;

import com.unibague.backpsyco.patient.domain.model.Patient;
import com.unibague.backpsyco.psychologist.domain.model.Psychologist;
import com.unibague.backpsyco.service.domain.model.Service;
import com.unibague.backpsyco.state.domain.model.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Appointment {
    private int id;
    private Timestamp date;
    private Service service;
    private Psychologist psychologist;
    private Patient patient;
    private State state;
}