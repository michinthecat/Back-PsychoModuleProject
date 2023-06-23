package com.unibague.backpsyco.patienttype.infraestructure.driveradapter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientTypeRepository extends JpaRepository<PatientTypeData, Integer> {
}
