package com.unibague.backpsyco.state.infraestructure.driveradapter;
import com.unibague.backpsyco.appointmentcorrect.infraestructure.driveradapter.AppointmentData;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "states")
@Data
public class StateData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "state", nullable = false)
    private String state;

    // Agrega la relación uno a muchos con la tabla 'appointments'
    @OneToMany(mappedBy = "state")
    private Set<AppointmentData> appointments;
}