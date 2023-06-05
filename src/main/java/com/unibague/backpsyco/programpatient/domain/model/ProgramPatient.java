package com.unibague.backpsyco.programpatient.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProgramPatient {
    private int programId;
    private int patientId;
    private int semesterId;
}