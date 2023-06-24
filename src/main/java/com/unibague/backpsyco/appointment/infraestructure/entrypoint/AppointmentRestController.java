package com.unibague.backpsyco.appointment.infraestructure.entrypoint;


import com.unibague.backpsyco.appointment.domain.model.Appointment;
import com.unibague.backpsyco.appointment.domain.usecase.AppointmentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment")
public class AppointmentRestController {

    private final AppointmentUseCase appointmentUseCase;

    @GetMapping("/date/{date}/psychologist/{psychologistId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDateAndPsychologistId(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @PathVariable int psychologistId) {
            return ResponseEntity.ok(appointmentUseCase.getAppointmentsByDateAndPsychologistId(date, psychologistId));
    }


    @GetMapping("/range")
    public ResponseEntity<List<Appointment>> getAppointmentsByDateRangeAndPsychologistId(
            @RequestParam("start") String startStr,
            @RequestParam("end") String endStr,
            @RequestParam("psychologistId") int psychologistId
    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime startDateTime = LocalDateTime.parse(startStr, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endStr, formatter);

        Date startDate = Date.from(startDateTime.atZone(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(endDateTime.atZone(ZoneId.systemDefault()).toInstant());

        List<Appointment> appointments = appointmentUseCase.getAppointmentsByDateRangeAndPsychologistId(startDate, endDate, psychologistId);
        return appointments != null && !appointments.isEmpty()
                ? ResponseEntity.ok(appointments)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/{id}/reschedule")
    public ResponseEntity<Appointment> rescheduleAppointment(
            @PathVariable("id") int appointmentId,
            @RequestParam("newDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime newDateTime
    ) {
        try {
            Appointment appointment = appointmentUseCase.rescheduleAppointment(appointmentId, newDateTime);
            return ResponseEntity.ok(appointment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<String> cancelAppointment(@PathVariable("id") int appointmentId) {
        try {
            if (appointmentUseCase.cancelAppointment(appointmentId)) {
                return new ResponseEntity<>("Cita eliminada exitosamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Ocurrio un error al eliminar la cita", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("No se encontro el ID de la Cita:" + appointmentId, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") int appointmentId) {
        try {
            Appointment appointment = appointmentUseCase.getAppointmentById(appointmentId);
            return ResponseEntity.ok(appointment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }





}
