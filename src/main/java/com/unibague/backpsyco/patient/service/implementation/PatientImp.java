package com.unibague.backpsyco.patient.service.implementation;

import com.unibague.backpsyco.patient.model.PatientDTO;
import com.unibague.backpsyco.patient.repository.PatientRepository;
import com.unibague.backpsyco.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientImp implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientImp(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientDTO createPatient(PatientDTO patient) {
        return patientRepository.save(patient);
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patient not found with id: " + id));
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public PatientDTO updatePatient(PatientDTO patient) {
        if (patientRepository.existsById(patient.getId())) {
            return patientRepository.save(patient);
        } else {
            throw new IllegalArgumentException("Patient not found with id: " + patient.getId());
        }
    }

    @Override
    public void deletePatient(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Patient not found with id: " + id);
        }
    }
}