package com.unibague.backpsyco.patient.domain.model.gateway;

import com.unibague.backpsyco.patient.domain.model.Patient;

import java.util.List;

public interface PatientGateway {

    Patient getPatientById(int patientId);
    Patient updatePatient(Patient patient);
    String getPatientNotes(int patientId);
    Patient updatePatientNotes(int patientId, String newNotes);


}
