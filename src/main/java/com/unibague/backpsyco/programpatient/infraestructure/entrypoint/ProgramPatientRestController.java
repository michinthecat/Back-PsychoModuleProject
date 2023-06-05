package com.unibague.backpsyco.programpatient.infraestructure.entrypoint;

import com.unibague.backpsyco.programpatient.infraestructure.driveradapter.ProgramPatientData;
import com.unibague.backpsyco.programpatient.infraestructure.driveradapter.ProgramPatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("programPatient")
public class ProgramPatientRestController {


    private final ProgramPatientRepository programPatientRepository;

    @GetMapping
    public List<ProgramPatientData> getAllProgramPatient() {
        return programPatientRepository.findAll();
    }
}
