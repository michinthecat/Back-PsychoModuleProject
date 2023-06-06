package com.unibague.backpsyco.appointment.infraestructure.entrypoint;


import com.unibague.backpsyco.appointment.domain.model.Appointment;
import com.unibague.backpsyco.appointment.domain.usecase.AppointmentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment")
public class AppointmentRestController {

    private final AppointmentUseCase appointmentUseCase;

    @GetMapping("/psychologist/{psychologistId}")
    public List<Appointment> getAppointmentsByPsychologistId(@PathVariable int psychologistId) {
        return appointmentUseCase.getAppointmentsByPsychologistId(psychologistId);
    }

    @GetMapping("/date/{date}/psychologist/{psychologistId}")
    public List<Appointment> getAppointmentsByDateAndPsychologistId(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @PathVariable int psychologistId) {
        return appointmentUseCase.getAppointmentsByDateAndPsychologistId(date, psychologistId);
    }

    @GetMapping("/patient/{patientId}/psychologist/{psychologistId}")
    public List<Appointment> getAppointmentsByPatientIdAndPsychologistId(
            @PathVariable int patientId,
            @PathVariable int psychologistId) {
        return appointmentUseCase.getAppointmentsByPatientIdAndPsychologistId(patientId, psychologistId);
    }

    @GetMapping("/state/{state}/psychologist/{psychologistId}")
    public List<Appointment> getAppointmentsByStateAndPsychologistId(
            @PathVariable String state,
            @PathVariable int psychologistId) {
        return appointmentUseCase.getAppointmentsByStateAndPsychologistId(state, psychologistId);
    }

}
