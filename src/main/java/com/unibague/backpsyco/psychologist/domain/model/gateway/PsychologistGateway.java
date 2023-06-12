package com.unibague.backpsyco.psychologist.domain.model.gateway;


import com.unibague.backpsyco.psychologist.domain.model.Psychologist;

import java.util.List;

public interface PsychologistGateway {
    List<Psychologist> getAll();
    Psychologist getById(int id);

}
