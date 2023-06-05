package com.unibague.backpsyco.appointment.service.implementation;

import com.unibague.backpsyco.appointment.model.AppointmentDTO;
import com.unibague.backpsyco.appointment.repository.AppointmentRepository;
import com.unibague.backpsyco.appointment.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentImp implements AppointmentService {

    private final AppointmentRepository appointmentRepository;


    public AppointmentImp(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public AppointmentDTO getAppointmentById(Long appointmentId) {
        Optional<AppointmentDTO> appointment = appointmentRepository.findById(appointmentId);
        return appointment.orElse(null);
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    @Override
    public AppointmentDTO updateAppointment(AppointmentDTO appointment) {
        if(appointmentRepository.existsById(appointment.getAppointmentId())) {
            return appointmentRepository.save(appointment);
        } else {
            return null;
        }
    }

    @Override
    public void cancelAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public void updateAppointmentStatus(Long appointmentId, String newStatus) {
        AppointmentDTO appointment = appointmentRepository.findById(appointmentId).orElse(null);

        if (appointment != null) {
            appointment.setAppointmentStatus(newStatus);
            appointmentRepository.save(appointment);
        }
    }


}
