package com.unibague.backpsyco.appointment.domain.model;

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
    private int serviceId;
    private int psychologistId;
    private int patientId;
    private int stateId;
}