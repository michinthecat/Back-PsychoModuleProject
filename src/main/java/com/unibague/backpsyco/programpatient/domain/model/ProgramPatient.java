package com.unibague.backpsyco.programpatient.domain.model;

import com.unibague.backpsyco.patient.domain.model.Patient;
import com.unibague.backpsyco.program.domain.model.Program;
import com.unibague.backpsyco.semester.domain.model.Semester;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProgramPatient {

    private int id;
    private Program program;
    private Patient patient;
    private Semester semester;


}