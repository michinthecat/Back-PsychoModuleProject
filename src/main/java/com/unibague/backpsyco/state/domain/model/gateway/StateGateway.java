package com.unibague.backpsyco.state.domain.model.gateway;

import com.unibague.backpsyco.state.domain.model.State;

import java.util.List;

//Contratos
public interface StateGateway {

    public void saveState(State state);

    public State getStateById(Integer id);

    public void deleteStateById(Integer id);

    public void updateState(State state);

    public List<State> getAllState();
}
