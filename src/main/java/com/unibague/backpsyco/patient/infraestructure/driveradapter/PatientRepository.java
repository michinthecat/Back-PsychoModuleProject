package com.unibague.backpsyco.patient.infraestructure.driveradapter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientData, Integer> {
}
