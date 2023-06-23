package com.unibague.backpsyco.patienttype.domain.usecase;

import com.unibague.backpsyco.patienttype.domain.model.PatientType;
import com.unibague.backpsyco.patienttype.domain.model.gateway.PatientTypeGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PatientTypeUseCase implements PatientTypeGateway {

    private final PatientTypeGateway patientTypeGateway;
    @Override
    public List<PatientType> getAllPatientsType() {
        return patientTypeGateway.getAllPatientsType();
    }
}
