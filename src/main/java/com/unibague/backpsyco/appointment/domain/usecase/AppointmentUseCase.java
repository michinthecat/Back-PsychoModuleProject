package com.unibague.backpsyco.appointment.domain.usecase;

import com.unibague.backpsyco.appointment.domain.model.Appointment;
import com.unibague.backpsyco.appointment.domain.model.gateway.AppointmentGateway;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

//Aca se implementa el contrato del gateway que se usara en el Controller
@RequiredArgsConstructor
public class AppointmentUseCase {

    private final AppointmentGateway appointmentGateway;

    public List<Appointment> getAppointmentsByDateAndPsychologistId(Date date, int psychologistId) {
        if(date == null){
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }
        return appointmentGateway.getAppointmentsByDateAndPsychologistId(date, psychologistId);
    }

    public List<Appointment> getAppointmentsByDateRangeAndPsychologistId(Date startDate, Date endDate, int psychologistId) {
        return appointmentGateway.getAppointmentsByDateRangeAndPsychologistId(startDate, endDate, psychologistId);
    }

    public Appointment rescheduleAppointment(int appointmentId, LocalDateTime newDateTime) {
        return appointmentGateway.rescheduleAppointment(appointmentId, newDateTime);
    }

    public boolean cancelAppointment(int appointmentId) {
        return appointmentGateway.cancelAppointment(appointmentId);
    }





}