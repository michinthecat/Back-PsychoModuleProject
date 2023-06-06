package com.unibague.backpsyco.appointment.infraestructure.driveradapter;

import com.unibague.backpsyco.appointment.domain.model.Appointment;
import com.unibague.backpsyco.appointment.domain.model.gateway.AppointmentGateway;
import com.unibague.backpsyco.appointment.infraestructure.mapper.AppointmentMapper;
import com.unibague.backpsyco.state.infraestructure.driveradapter.StateData;
import com.unibague.backpsyco.state.infraestructure.driveradapter.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class AppointmentAdapterRepository implements AppointmentGateway {

    private final AppointmentRepository appointmentRepository;
    private final StateRepository stateRepository;

    @Override
    public List<Appointment> getAppointmentsByPsychologistId(int psychologistId) {
        return appointmentRepository.findByPsychologistId(psychologistId).stream()
                .map(AppointmentMapper::fromData)
                .collect(Collectors.toList());
    }

    @Override
    public List<Appointment> getAppointmentsByDateAndPsychologistId(Date date, int psychologistId) {
        return appointmentRepository.findByDateAndPsychologistId(date, psychologistId).stream()
                .map(AppointmentMapper::fromData)
                .collect(Collectors.toList());
    }

    @Override
    public List<Appointment> getAppointmentsByPatientIdAndPsychologistId(int patientId, int psychologistId) {
        return appointmentRepository.findByPatientIdAndPsychologistId(patientId, psychologistId).stream()
                .map(AppointmentMapper::fromData)
                .collect(Collectors.toList());
    }

    @Override
    public List<Appointment> getAppointmentsByStateAndPsychologistId(String state, int psychologistId) {
        StateData stateData = stateRepository.findByState(state.toUpperCase())
                .orElseThrow(() -> new IllegalArgumentException("State not found"));
        return appointmentRepository.findByStateAndPsychologistId(stateData, psychologistId).stream()
                .map(AppointmentMapper::fromData)
                .collect(Collectors.toList());
    }
}