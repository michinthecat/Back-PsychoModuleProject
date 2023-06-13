package com.unibague.backpsyco.psychologist.infraestructure.entrypoint;

import com.unibague.backpsyco.psychologist.domain.model.Psychologist;
import com.unibague.backpsyco.psychologist.domain.usecase.PsychologistUseCase;
import com.unibague.backpsyco.schedule.domain.model.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/psychologists")
@RequiredArgsConstructor
public class PsychologistRestController {

    private final PsychologistUseCase psychologistUseCase;

    @GetMapping
    public ResponseEntity<List<Psychologist>> getAll() {
        return new ResponseEntity<>(psychologistUseCase.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Psychologist> getById(@PathVariable int id) {
        return new ResponseEntity<>(psychologistUseCase.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Psychologist> savePsychologist(@RequestBody @Validated Psychologist psychologist) {
        Psychologist savedPsychologist = psychologistUseCase.save(psychologist);
        return new ResponseEntity<>(savedPsychologist, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePsychologist(@PathVariable int id) {
        return new ResponseEntity<>(psychologistUseCase.delete(id), HttpStatus.OK);
    }

}