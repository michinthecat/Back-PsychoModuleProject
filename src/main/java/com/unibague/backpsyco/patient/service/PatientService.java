package com.unibague.backpsyco.patient.service;

import com.unibague.backpsyco.patient.model.PatientDTO;

import java.util.List;

public interface PatientService {

    PatientDTO createPatient(PatientDTO patient);

    PatientDTO getPatientById(Long id);

    List<PatientDTO> getAllPatients();

    PatientDTO updatePatient(PatientDTO patient);

    void deletePatient(Long id);
}