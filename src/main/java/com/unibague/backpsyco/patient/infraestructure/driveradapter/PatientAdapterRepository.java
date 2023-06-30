package com.unibague.backpsyco.patient.infraestructure.driveradapter;

import com.unibague.backpsyco.patient.domain.model.Patient;
import com.unibague.backpsyco.patient.domain.model.gateway.PatientGateway;
import com.unibague.backpsyco.patient.infraestructure.mapper.PatientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PatientAdapterRepository implements PatientGateway {

    private final PatientRepository patientRepository;

    @Override
    public Patient getPatientById(int patientId) {
        PatientData patientData = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Paciente No Encontrado Con El Id: " + patientId));
        return PatientMapper.fromData(patientData);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        if (patientRepository.existsById(patient.getId())) {
            PatientData patientData = PatientMapper.toData(patient);
            return PatientMapper.fromData(patientRepository.save(patientData));
        }
        throw new IllegalArgumentException("El Id Del Paciente No Existe");
    }

    @Override
    public Patient updatePatientNotes(int patientId, String newNotes) {
        PatientData patientData = patientRepository.findById(patientId).orElseThrow(() -> new IllegalArgumentException("Id No Valido:" + patientId));
        patientData.setNotes(newNotes);
        return PatientMapper.fromData(patientRepository.save(patientData));
    }
}