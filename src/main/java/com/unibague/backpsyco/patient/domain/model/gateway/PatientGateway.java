package com.unibague.backpsyco.patient.domain.model.gateway;

import com.unibague.backpsyco.patient.domain.model.Patient;

import java.util.List;

public interface PatientGateway {

    Patient updatePatient(Patient patient);
    Patient getPatientById(int patientId);
    String getPatientNotes(int patientId);
    Patient updatePatientNotes(int patientId, String newNotes);


}
