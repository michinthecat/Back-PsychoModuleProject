package com.unibague.backpsyco.patient.domain.usecase;

import com.unibague.backpsyco.patient.domain.model.Patient;
import com.unibague.backpsyco.patient.domain.model.gateway.PatientGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PatientUseCase {

    private final PatientGateway patientGateway;

    public Patient updatePatient(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("El paciente no puede ser nulo");
        }
        return patientGateway.updatePatient(patient);
    }

    public Patient getPatientById(int patientId) {
        return patientGateway.getPatientById(patientId);
    }

    public String getPatientNotes(int patientId) {
        return patientGateway.getPatientNotes(patientId);
    }

    public Patient updatePatientNotes(int patientId, String newNotes) {
        if (newNotes == null || newNotes.isEmpty()) {
            throw new IllegalArgumentException("Las notas nuevas no pueden ser nulas o vacías");
        }
        return patientGateway.updatePatientNotes(patientId, newNotes);
    }
}