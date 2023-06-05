package com.unibague.backpsyco.programpatient.infraestructure.driveradapter;

import com.unibague.backpsyco.patient.infraestructure.driveradapter.PatientData;
import com.unibague.backpsyco.program.infraestructure.driveradapter.ProgramData;
import com.unibague.backpsyco.semester.infraestructure.driveradapter.SemesterData;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "programs_patients")
@Data
public class ProgramPatientData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "patientId", nullable = false)
    private PatientData patient;

    @ManyToOne
    @JoinColumn(name = "programid", nullable = false)
    private ProgramData program;

    @ManyToOne
    @JoinColumn(name = "semesterid", nullable = false)
    private SemesterData semester;
}