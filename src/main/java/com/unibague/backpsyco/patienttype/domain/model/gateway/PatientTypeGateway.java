package com.unibague.backpsyco.patienttype.domain.model.gateway;

import com.unibague.backpsyco.patienttype.domain.model.PatientType;

import java.util.List;

public interface PatientTypeGateway {
    List<PatientType> getAllPatientsType();
}
