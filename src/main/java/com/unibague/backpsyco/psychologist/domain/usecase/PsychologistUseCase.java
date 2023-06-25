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

    public Psychologist createPsychologist(Psychologist psychologist){return psychologistGateway.createPsychologist(psychologist);}
    public Psychologist updatePsychologist(Psychologist psychologist){return psychologistGateway.updatePsychologist(psychologist);}

    public Boolean delete(int id){return psychologistGateway.delete(id);}

    public Boolean insertServiceToPsychologist(int psychologistId, int serviceId){return psychologistGateway.insertServiceToPsychologist(psychologistId, serviceId);}
}
