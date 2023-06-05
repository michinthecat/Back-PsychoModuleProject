package com.unibague.backpsyco.role.infraestructure.driveradapter;

import com.unibague.backpsyco.psychologist.infraestructure.driveradapter.PsychologistData;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "roles")
@Data
public class RoleData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role", nullable = false)
    private String role;

    // Agrega la relación con la tabla 'psychologists'
    @OneToMany(mappedBy = "role")
    private Set<PsychologistData> psychologists;
}