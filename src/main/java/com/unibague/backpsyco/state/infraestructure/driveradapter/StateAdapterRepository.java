package com.unibague.backpsyco.state.infraestructure.driveradapter;

import com.unibague.backpsyco.state.domain.model.State;
import com.unibague.backpsyco.state.domain.model.gateway.StateGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class StateAdapterRepository implements StateGateway {

    private final StateRepository stateRepository;

    private State mapToState(StateData stateData) {
        State state = new State();
        state.setId(stateData.getId());
        state.setState(stateData.getState());
        return state;
    }

    @Override
    public State findByName(String name) {
        Optional<StateData> optionalStateData = stateRepository.findByState(name);
        return optionalStateData.map(this::mapToState).orElse(null);
    }
}
