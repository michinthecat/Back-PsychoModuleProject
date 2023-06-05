package com.unibague.backpsyco.gender.infraestructure.driveradapter;

import com.unibague.backpsyco.patient.infraestructure.driveradapter.PatientData;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Entity
@Table(name = "genders")
@Data
public class GenderData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "gender", nullable = false)
    private String gender;

}