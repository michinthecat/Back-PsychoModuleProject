package com.unibague.backpsyco.patienttype.infraestructure.mapper;

import com.unibague.backpsyco.patienttype.domain.model.PatientType;
import com.unibague.backpsyco.patienttype.infraestructure.driveradapter.PatientTypeData;

public class PatientTypeMapper {

    public static PatientType toDomain(PatientTypeData patientTypeData) {
        PatientType patientType = new PatientType();
        patientType.setId(patientTypeData.getId());
        patientType.setPatientType(patientTypeData.getType());
        return patientType;
    }

    public static PatientTypeData toData(PatientType patientType) {
        PatientTypeData patientTypeData = new PatientTypeData();
        patientTypeData.setId(patientType.getId());
        patientTypeData.setType(patientType.getPatientType());
        return patientTypeData;
    }
}