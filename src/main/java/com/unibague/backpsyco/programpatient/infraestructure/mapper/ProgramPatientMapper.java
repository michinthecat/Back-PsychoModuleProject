package com.unibague.backpsyco.programpatient.infraestructure.mapper;

import com.unibague.backpsyco.gender.domain.model.Gender;
import com.unibague.backpsyco.patient.domain.model.Patient;
import com.unibague.backpsyco.patienttype.domain.model.PatientType;
import com.unibague.backpsyco.program.domain.model.Program;
import com.unibague.backpsyco.programpatient.domain.model.ProgramPatient;
import com.unibague.backpsyco.programpatient.infraestructure.driveradapter.ProgramPatientData;
import com.unibague.backpsyco.semester.domain.model.Semester;

public class ProgramPatientMapper {
    public static ProgramPatient fromData(ProgramPatientData data) {
        ProgramPatient programPatient = new ProgramPatient();
        programPatient.setId(data.getId());

        Program program = new Program();
        program.setId(data.getProgram().getId());
        program.setProgram(data.getProgram().getProgram());
        programPatient.setProgram(program);

        Patient patient = new Patient();
        patient.setId(data.getPatient().getId());
        patient.setName(data.getPatient().getName());
        patient.setLastName(data.getPatient().getLastName());
        patient.setEmail(data.getPatient().getEmail());
        patient.setAge(data.getPatient().getAge());
        patient.setPhone(data.getPatient().getPhone());
        patient.setNotes(data.getPatient().getNotes());

        Gender gender = new Gender();
        gender.setId(data.getPatient().getGender().getId());
        gender.setGender(data.getPatient().getGender().getGender());
        patient.setGender(gender);

        PatientType patientType = new PatientType();
        patientType.setId(data.getPatient().getPatientType().getId());
        patientType.setPatientType(data.getPatient().getPatientType().getType());
        patient.setPatientType(patientType);

        programPatient.setPatient(patient);

        Semester semester = new Semester();
        semester.setId(data.getSemester().getId());
        semester.setSemester(data.getSemester().getSemester());
        programPatient.setSemester(semester);

        return programPatient;
    }
}