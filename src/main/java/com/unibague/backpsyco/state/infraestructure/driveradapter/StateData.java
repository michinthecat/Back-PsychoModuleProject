package com.unibague.backpsyco.state.infraestructure.driveradapter;
import com.unibague.backpsyco.appointment.infraestructure.driveradapter.AppointmentData;
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

}