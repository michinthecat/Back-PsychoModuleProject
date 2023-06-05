package com.unibague.backpsyco.state.domain.usecase;

import com.unibague.backpsyco.state.domain.model.State;
import com.unibague.backpsyco.state.domain.model.gateway.StateGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class StateUseCase {

    private final StateGateway stateGateway;

    public void saveState(State state) {
        validateState(state);
        stateGateway.saveState(state);
    }

    public State getStateById(Integer id) {
        validateId(id);
        return stateGateway.getStateById(id);
    }

    public void updateState(State state) {
        validateState(state);
        stateGateway.updateState(state);
    }

    public void deleteStateById(Integer id) {
        validateId(id);
        stateGateway.deleteStateById(id);
    }

    public List<State> getAllStates() {
        return stateGateway.getAllState();
    }

    private void validateState(State state) {
        if (state == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo");
        }
        if (state.getState().isEmpty()) {
            throw new IllegalArgumentException("El estado no puede ser vacío");
        }
    }

    private void validateId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }
    }
}
