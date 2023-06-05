package com.unibague.backpsyco.patienttype.infraestructure.driveradapter;

import com.unibague.backpsyco.patient.infraestructure.driveradapter.PatientData;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "patient_types")
@Data
public class PatientTypeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type", nullable = false)
    private String type;

    // Agrega la relación con la tabla 'patients'
    @OneToMany(mappedBy = "patientType")
    private Set<PatientData> patients;
}
