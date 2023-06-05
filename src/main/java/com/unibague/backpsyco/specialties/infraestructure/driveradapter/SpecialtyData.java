package com.unibague.backpsyco.specialties.infraestructure.driveradapter;

import com.unibague.backpsyco.psychologist.infraestructure.driveradapter.PsychologistData;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "specialties")
@Data
public class SpecialtyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "specialty", nullable = false)
    private String specialty;

    // Agrega la relación con la tabla 'psychologists'
    @OneToMany(mappedBy = "specialty")
    private Set<PsychologistData> psychologists;
}