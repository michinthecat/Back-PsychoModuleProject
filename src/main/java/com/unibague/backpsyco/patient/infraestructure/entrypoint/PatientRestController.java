package com.unibague.backpsyco.patient.infraestructure.entrypoint;

import com.unibague.backpsyco.patient.domain.model.Patient;
import com.unibague.backpsyco.patient.domain.usecase.PatientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientRestController {

    private final PatientUseCase patientUseCase;

    @PutMapping
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientUseCase.updatePatient(patient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") int patientId) {
        return ResponseEntity.of(Optional.of(patientUseCase.getPatientById(patientId)));
    }

    @GetMapping("/{id}/notes")
    public ResponseEntity<String> getPatientNotes(@PathVariable("id") int patientId) {
        return ResponseEntity.ok(patientUseCase.getPatientNotes(patientId));
    }

    @PatchMapping("/{id}/notes")
    public ResponseEntity<Patient> updatePatientNotes(@PathVariable("id") int patientId, @RequestBody String newNotes) {
        return ResponseEntity.ok(patientUseCase.updatePatientNotes(patientId, newNotes));
    }
}