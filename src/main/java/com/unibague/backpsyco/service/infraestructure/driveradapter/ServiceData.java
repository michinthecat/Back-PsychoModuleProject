package com.unibague.backpsyco.service.infraestructure.driveradapter;

import com.unibague.backpsyco.appointmentcorrect.infraestructure.driveradapter.AppointmentData;
import com.unibague.backpsyco.psychologist.infraestructure.driveradapter.PsychologistData;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "services")
@Data
public class ServiceData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @Column(name = "description")
    private String description;

    @Column(name = "cost", nullable = false)
    private float cost;

    // Agrega la relación de muchos a muchos con la tabla 'psychologists'
    @ManyToMany(mappedBy = "services")
    private Set<PsychologistData> psychologists;

    // Agrega la relación uno a muchos con la tabla 'appointments'
    @OneToMany(mappedBy = "service")
    private Set<AppointmentData> appointments;
}