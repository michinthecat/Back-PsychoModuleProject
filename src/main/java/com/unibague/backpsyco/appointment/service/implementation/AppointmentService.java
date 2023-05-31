package com.unibague.backpsyco.appointment.service.implementation;

import com.unibague.backpsyco.appointment.model.AppointmentDTO;

import java.util.List;


public interface AppointmentService {

      AppointmentDTO createAppointment(AppointmentDTO appointment);

      AppointmentDTO getAppointmentById(Long appointmentId);

      List<AppointmentDTO> getAppointmentsByPatientId(Long patientId);

      List<AppointmentDTO> getAppointmentsByDoctorId(Long doctorId);

      AppointmentDTO updateAppointment(AppointmentDTO appointment);

      void cancelAppointment(Long appointmentId);

      List<AppointmentDTO> getAllAppointments();

      void updateAppointmentStatus(Long appointmentId, String newStatus);

}
