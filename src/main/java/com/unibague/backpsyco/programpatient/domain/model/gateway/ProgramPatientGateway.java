package com.unibague.backpsyco.programpatient.domain.model.gateway;

import com.unibague.backpsyco.programpatient.domain.model.ProgramPatient;

import java.util.List;

public interface ProgramPatientGateway {

    List<ProgramPatient> findByPatientId(int patientId);
}
