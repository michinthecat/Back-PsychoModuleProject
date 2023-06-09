package com.unibague.backpsyco.programpatient.infraestructure.entrypoint;

import com.unibague.backpsyco.programpatient.domain.model.ProgramPatient;
import com.unibague.backpsyco.programpatient.domain.model.usecase.ProgramPatientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("programPatient")
public class ProgramPatientRestController {

    private final ProgramPatientUseCase programPatientUseCase;

    @GetMapping("/{patientId}")
    public List<ProgramPatient> findByPatientId(@PathVariable int patientId) {
        return programPatientUseCase.findByPatientId(patientId);
    }



}
