package com.unibague.backpsyco.semester.infraestructure.driveradapter;

import com.unibague.backpsyco.programpatient.infraestructure.driveradapter.ProgramPatientData;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "semesters")
@Data
public class SemesterData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "semester", nullable = false)
    private String semester;

}