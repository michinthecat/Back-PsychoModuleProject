package com.unibague.backpsyco.programpatient.infraestructure.driveradapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProgramPatientRepository extends JpaRepository<ProgramPatientData, Integer> {
    List<ProgramPatientData> findByPatient_Id(int patientId);
}
