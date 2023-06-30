package com.unibague.backpsyco.patient.domain.model.gateway;

import com.unibague.backpsyco.patient.domain.model.Patient;

public interface PatientGateway {

    Patient getPatientById(int patientId);
    Patient updatePatient(Patient patient);
    Patient updatePatientNotes(int patientId, String newNotes);

}
