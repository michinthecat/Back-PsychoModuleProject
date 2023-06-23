package com.unibague.backpsyco.patienttype.infraestructure.entrypoint;

import com.unibague.backpsyco.patienttype.domain.model.PatientType;
import com.unibague.backpsyco.patienttype.domain.usecase.PatientTypeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PatientTypes")
@RequiredArgsConstructor
public class PatientTypeRestController {

    private final PatientTypeUseCase patientTypeUseCase;

    @GetMapping
    public ResponseEntity<List<PatientType>> getAllPatientTypes() {
        List<PatientType> patientTypes = patientTypeUseCase.getAllPatientsType();
        return ResponseEntity.ok(patientTypes);
    }
}
