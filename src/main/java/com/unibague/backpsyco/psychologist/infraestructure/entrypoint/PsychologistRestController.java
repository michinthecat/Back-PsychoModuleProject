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
        Psychologist psychologist = psychologistUseCase.getById(id);
        if (psychologist != null) {
            return ResponseEntity.ok(psychologist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Psychologist> updatePsychologist(@PathVariable int id, @RequestBody @Validated Psychologist psychologist) {
        psychologist.setId(id);
        Psychologist updatedPsychologist = psychologistUseCase.updatePsychologist(psychologist);
        if (updatedPsychologist != null) {
            return ResponseEntity.ok(updatedPsychologist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePsychologist(@PathVariable int id) {
        boolean success = psychologistUseCase.delete(id);
        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/{psychologistId}/services/{serviceId}")
    public ResponseEntity<String> insertServiceToPsychologist(@PathVariable int psychologistId, @PathVariable int serviceId) {
        boolean success = psychologistUseCase.insertServiceToPsychologist(psychologistId, serviceId);
        if (success) {
            return ResponseEntity.ok("Service inserted to psychologist successfully");
        } else {
            return ResponseEntity.badRequest().body("Psychologist or service not found");
        }
    }

    @PostMapping
    public ResponseEntity<Psychologist> createPsychologist(@RequestBody @Validated Psychologist psychologist) {
        try {
            Psychologist createdPsychologist = psychologistUseCase.createPsychologist(psychologist);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPsychologist);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }



}