package com.unibague.backpsyco.appointment.domain.usecase;

import com.unibague.backpsyco.appointment.domain.model.Appointment;
import com.unibague.backpsyco.appointment.domain.model.gateway.AppointmentGateway;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class AppointmentUseCase {

    private final AppointmentGateway appointmentGateway;

    public List<Appointment> getAppointmentsByPsychologistId(int psychologistId) {
        return appointmentGateway.getAppointmentsByPsychologistId(psychologistId);
    }

    public List<Appointment> getAppointmentsByDateAndPsychologistId(Date date, int psychologistId) {
        if(date == null){
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }
        return appointmentGateway.getAppointmentsByDateAndPsychologistId(date, psychologistId);
    }

    public List<Appointment> getAppointmentsByPatientIdAndPsychologistId(int patientId, int psychologistId) {
        return appointmentGateway.getAppointmentsByPatientIdAndPsychologistId(patientId, psychologistId);
    }

    public List<Appointment> getAppointmentsByStateAndPsychologistId(String state, int psychologistId) {
        if(state == null || state.isEmpty()){
            throw new IllegalArgumentException("El estado no puede ser nulo o vacío");
        }
        return appointmentGateway.getAppointmentsByStateAndPsychologistId(state, psychologistId);
    }

}