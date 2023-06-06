package com.unibague.backpsyco.appointment.infraestructure.mapper;

import com.unibague.backpsyco.appointment.domain.model.Appointment;
import com.unibague.backpsyco.appointment.infraestructure.driveradapter.AppointmentData;

import java.sql.Timestamp;

public class AppointmentMapper {
    public static Appointment fromData(AppointmentData appointmentData) {
        return new Appointment(
                appointmentData.getId(),
                new Timestamp(appointmentData.getDate().getTime()),
                appointmentData.getService().getId(),
                appointmentData.getPsychologist().getId(),
                appointmentData.getPatient().getId(),
                appointmentData.getState().getId()
        );
    }
}
