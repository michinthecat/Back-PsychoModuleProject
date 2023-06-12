package com.unibague.backpsyco.specialties.infraestructure.driveradapter;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "specialties")
@Data
public class SpecialityData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "specialty", nullable = false)
    private String specialty;


}