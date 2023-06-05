package com.unibague.backpsyco.programpatient.infraestructure.driveradapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramPatientRepository extends JpaRepository<ProgramPatientData, Integer> {
}
