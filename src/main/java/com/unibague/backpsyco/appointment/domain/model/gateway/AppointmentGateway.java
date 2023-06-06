package com.unibague.backpsyco.appointment.domain.model.gateway;

import com.unibague.backpsyco.appointment.domain.model.Appointment;

import java.util.Date;
import java.util.List;

public interface AppointmentGateway {

    List<Appointment> getAppointmentsByPsychologistId(int psychologistId);
    List<Appointment> getAppointmentsByDateAndPsychologistId(Date date, int psychologistId);
    List<Appointment> getAppointmentsByPatientIdAndPsychologistId(int patientId, int psychologistId);
    List<Appointment> getAppointmentsByStateAndPsychologistId(String state, int psychologistId);
}
