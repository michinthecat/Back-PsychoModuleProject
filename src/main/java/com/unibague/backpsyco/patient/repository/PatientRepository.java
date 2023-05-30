package com.unibague.backpsyco.patient.repository;

import com.unibague.backpsyco.patient.model.PatientDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientDTO, Long> {

}
