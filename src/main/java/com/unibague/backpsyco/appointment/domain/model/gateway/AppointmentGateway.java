package com.unibague.backpsyco.appointment.domain.model.gateway;

import com.unibague.backpsyco.appointment.domain.model.Appointment;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface AppointmentGateway {

    List<Appointment> getAppointmentsByDateAndPsychologistId(Date date, int psychologistId);
    List<Appointment> getAppointmentsByDateRangeAndPsychologistId(Date startDate, Date endDate, int psychologistId);
    Appointment rescheduleAppointment(int appointmentId, LocalDateTime newDateTime);
    boolean cancelAppointment(int appointmentId);



}
