package com.unibague.backpsyco.appointment.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointment")
public class AppointmentDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @Column(name = "doctor_id", nullable = false)
    private Long doctorId;

    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime appointmentDate;

    @Column(name = "appointment_duration", nullable = false)
    private Duration appointmentDuration;

    @Column(name = "appointment_status", nullable = false)
    private String appointmentStatus;

    @Column(name = "appointment_type", nullable = false)
    private String appointmentType;

    @Column(name = "appointment_location", nullable = false)
    private String appointmentLocation;

    @Column(name = "notes")
    private String notes;
}
