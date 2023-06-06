package com.unibague.backpsyco.psychologist.infraestructure.driveradapter;


import com.unibague.backpsyco.appointment.infraestructure.driveradapter.AppointmentData;
import com.unibague.backpsyco.role.infraestructure.driveradapter.RoleData;
import com.unibague.backpsyco.schedule.infraestructure.driveradapter.ScheduleData;
import com.unibague.backpsyco.service.infraestructure.driveradapter.ServiceData;
import com.unibague.backpsyco.specialties.infraestructure.driveradapter.SpecialtyData;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "psychologists")
@Data
public class PsychologistData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "specialtyid", nullable = false)
    private SpecialtyData specialty;

    @ManyToOne
    @JoinColumn(name = "roleid", nullable = false)
    private RoleData role;

    // Services related to psychologist through a ManyToMany relationship
    @ManyToMany
    @JoinTable(
            name = "services_psychologists",
            joinColumns = @JoinColumn(name = "psychologistid"),
            inverseJoinColumns = @JoinColumn(name = "serviceid")
    )
    private List<ServiceData> services;

    // Schedules related to psychologist through a ManyToMany relationship
    @ManyToMany
    @JoinTable(
            name = "psychologists_schedules",
            joinColumns = @JoinColumn(name = "psychologistid"),
            inverseJoinColumns = @JoinColumn(name = "scheduleid")
    )
    private List<ScheduleData> schedules;

    // Agrega la relación uno a muchos con la tabla 'appointments'
    @OneToMany(mappedBy = "psychologist")
    private Set<AppointmentData> appointments;
}