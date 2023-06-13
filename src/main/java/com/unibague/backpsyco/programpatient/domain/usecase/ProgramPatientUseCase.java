package com.unibague.backpsyco.programpatient.domain.usecase;

import com.unibague.backpsyco.programpatient.domain.model.ProgramPatient;
import com.unibague.backpsyco.programpatient.domain.model.gateway.ProgramPatientGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class ProgramPatientUseCase {
    private final ProgramPatientGateway programPatientGateway;

    public List<ProgramPatient> findByPatientId(int patientId) {
        return programPatientGateway.findByPatientId(patientId);
    }
}
