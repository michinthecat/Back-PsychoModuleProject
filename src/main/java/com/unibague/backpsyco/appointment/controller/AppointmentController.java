package com.unibague.backpsyco.appointment.controller;

import com.unibague.backpsyco.appointment.model.AppointmentDTO;
import com.unibague.backpsyco.appointment.service.AppointmentService;
import com.unibague.backpsyco.email.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private final AppointmentService appointmentService;

    @Autowired
    private final MailService mailService = new MailService();


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

        AppointmentDTO appointmentDTO = appointmentService.getAppointmentById(appointmentId);

        mailService.sendConfirmationEmail("jhonedisonbravocasas@hotmail.com");

        return ResponseEntity.ok("<!DOCTYPE html>\n" +
                "<html lang=\"es\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\n" +
                "    <style>\n" +
                "        body {\n" +
                "            background-color: #f0f0f0;\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            padding: 20px;\n" +
                "        }\n" +
                "\n" +
                "        .container {\n" +
                "            max-width: 600px;\n" +
                "            margin: auto;\n" +
                "            background-color: white;\n" +
                "            padding: 20px;\n" +
                "            border-radius: 15px;\n" +
                "            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);\n" +
                "        }\n" +
                "\n" +
                "        .text-center {\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        .mb-3 {\n" +
                "            margin-bottom: 1rem;\n" +
                "        }\n" +
                "\n" +
                "        .justify {\n" +
                "            text-align: justify;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container\">\n" +
                "    <h1 class=\"text-center\" style=\"color: #ff535b;\">Confirmación de Cita</h1>\n" +
                "    <div class=\"text-center\">\n" +
                "        <img src=\"https://static.vecteezy.com/system/resources/previews/010/151/485/original/tick-icon-accept-approve-sign-design-free-png.png\" alt=\"Aprobado\" style=\"width: 100px; height: 100px;\">\n" +
                "    </div>\n" +
                "    <p class=\"mb-3 justify\" style=\"font-size: 18px; line-height: 1.6;\">\n" +
                "        ¡Felicidades! Tu cita ha sido confirmada con éxito.\n" +
                "    </p>\n" +
                "    <p class=\"mb-3 justify\" style=\"font-size: 18px; line-height: 1.6;\">\n" +
                "        Gracias por elegir nuestros servicios. Esperamos verte pronto.\n" +
                "    </p>\n" +
                "    <div class=\"text-center\">\n" +
                "        <a href=\"https://example.com\" class=\"btn btn-primary\">Volver al Sitio Web</a>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
    }

}