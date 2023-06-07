package com.unibague.backpsyco.patient.infraestructure.mapper;

import com.unibague.backpsyco.gender.domain.model.Gender;
import com.unibague.backpsyco.gender.infraestructure.driveradapter.GenderData;
import com.unibague.backpsyco.patient.domain.model.Patient;
import com.unibague.backpsyco.patient.infraestructure.driveradapter.PatientData;
import com.unibague.backpsyco.patienttype.domain.model.PatientType;
import com.unibague.backpsyco.patienttype.infraestructure.driveradapter.PatientTypeData;

public class PatientMapper {
    public static Patient fromData(PatientData data) {
        Patient patient = new Patient();
        patient.setId(data.getId());
        patient.setName(data.getName());
        patient.setLastName(data.getLastName());
        patient.setEmail(data.getEmail());
        patient.setAge(data.getAge());
        patient.setPhone(data.getPhone());
        patient.setNotes(data.getNotes());

        Gender gender = new Gender();
        gender.setId(data.getGender().getId());
        gender.setGender(data.getGender().getGender());

        PatientType patientType = new PatientType();
        patientType.setId(data.getPatientType().getId());
        patientType.setPatientType(data.getPatientType().getType());

        patient.setGender(gender);
        patient.setPatientType(patientType);

        return patient;
    }


    public static PatientData toData(Patient patient) {
        PatientData data = new PatientData();
        data.setId(patient.getId());
        data.setName(patient.getName());
        data.setLastName(patient.getLastName());
        data.setEmail(patient.getEmail());
        data.setAge(patient.getAge());
        data.setPhone(patient.getPhone());
        data.setNotes(patient.getNotes());

        GenderData genderData = new GenderData();
        genderData.setId(patient.getGender().getId());
        genderData.setGender(patient.getGender().getGender());

        PatientTypeData patientTypeData = new PatientTypeData();
        patientTypeData.setId(patient.getPatientType().getId());
        patientTypeData.setType(patient.getPatientType().getPatientType());

        data.setGender(genderData);
        data.setPatientType(patientTypeData);

        return data;
    }
}
