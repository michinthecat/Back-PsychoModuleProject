package com.unibague.backpsyco.state.infraestructure.driveradapter;

import com.unibague.backpsyco.state.domain.model.State;
import com.unibague.backpsyco.state.domain.model.gateway.StateGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class StateAdapterRepository implements StateGateway {

    private final StateRepository stateRepository;

    @Override
    public void saveState(State state) {
        StateData stateData = new StateData();
        stateData.setId(state.getId());
        stateData.setState(state.getState());
        stateRepository.save(stateData);
    }

    @Override
    public State getStateById(Integer id) {
        Optional<StateData> stateDataOptional = stateRepository.findById(id);
        return stateDataOptional.map(this::mapToState).orElse(null);
    }

    @Override
    public void deleteStateById(Integer id) {
        stateRepository.deleteById(id);
    }

    @Override
    public void updateState(State state) {
        Optional<StateData> stateDataOptional = stateRepository.findById(state.getId());
        if (stateDataOptional.isPresent()) {
            StateData stateData = stateDataOptional.get();
            stateData.setState(state.getState());
            stateRepository.save(stateData);
        }
    }

    @Override
    public List<State> getAllState() {
        List<StateData> stateDataList = stateRepository.findAll();
        return stateDataList.stream().map(this::mapToState).collect(Collectors.toList());
    }

    private State mapToState(StateData stateData) {
        State state = new State();
        state.setId(stateData.getId());
        state.setState(stateData.getState());
        return state;
    }
}
