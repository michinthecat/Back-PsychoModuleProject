package com.unibague.backpsyco.psychologist.domain.usecase;


import com.unibague.backpsyco.psychologist.domain.model.Psychologist;
import com.unibague.backpsyco.psychologist.domain.model.gateway.PsychologistGateway;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PsychologistUseCase {

    private final PsychologistGateway psychologistGateway;

    public List<Psychologist> getAll() {
        return psychologistGateway.getAll();
    }

    public Psychologist getById(int id) {
        return psychologistGateway.getById(id);
    }

}
