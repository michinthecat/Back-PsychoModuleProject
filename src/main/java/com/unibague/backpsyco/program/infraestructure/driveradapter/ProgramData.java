package com.unibague.backpsyco.program.infraestructure.driveradapter;
import com.unibague.backpsyco.programpatient.infraestructure.driveradapter.ProgramPatientData;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "programs")
@Data
public class ProgramData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "program", nullable = false)
    private String program;

}