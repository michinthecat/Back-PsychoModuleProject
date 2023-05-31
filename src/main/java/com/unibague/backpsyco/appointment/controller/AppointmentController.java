package com.unibague.backpsyco.appointment.controller;

import com.unibague.backpsyco.appointment.model.AppointmentDTO;
import com.unibague.backpsyco.appointment.service.implementation.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;



    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;


    }

    @PostMapping
    public AppointmentDTO createAppointment(@RequestBody AppointmentDTO appointment) {


        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("/{appointmentId}")
    public AppointmentDTO getAppointmentById(@PathVariable Long appointmentId) {
        return appointmentService.getAppointmentById(appointmentId);
    }

    @GetMapping("/patient/{patientId}")
    public List<AppointmentDTO> getAppointmentsByPatientId(@PathVariable Long patientId) {
        return appointmentService.getAppointmentsByPatientId(patientId);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<AppointmentDTO> getAppointmentsByDoctorId(@PathVariable Long doctorId) {
        return appointmentService.getAppointmentsByDoctorId(doctorId);
    }

    @PutMapping
    public AppointmentDTO updateAppointment(@RequestBody AppointmentDTO appointment) {
        return appointmentService.updateAppointment(appointment);
    }

    @DeleteMapping("/{appointmentId}")
    public void cancelAppointment(@PathVariable Long appointmentId) {
        appointmentService.cancelAppointment(appointmentId);
    }

    @GetMapping
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{appointmentId}/status")
    public ResponseEntity<String> updateAppointmentStatus(@PathVariable Long appointmentId,
                                                          @RequestParam String newStatus) {
        appointmentService.updateAppointmentStatus(appointmentId, newStatus);
        return ResponseEntity.ok("Estado de la reserva actualizado correctamente");
    }

}