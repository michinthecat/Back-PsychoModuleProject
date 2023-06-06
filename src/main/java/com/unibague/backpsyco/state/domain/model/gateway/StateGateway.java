package com.unibague.backpsyco.state.domain.model.gateway;

import com.unibague.backpsyco.state.domain.model.State;

import java.util.List;

//Contratos
public interface StateGateway {

  //Busca por nombre
    State findByName(String name);
}
