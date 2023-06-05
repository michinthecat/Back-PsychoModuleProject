package com.unibague.backpsyco.patienttype.infraestructure.driveradapter;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "patient_types")
@Data
public class PatientTypeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type", nullable = false)
    private String type;

}
