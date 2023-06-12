package com.unibague.backpsyco.state.infraestructure.mapper;

import com.unibague.backpsyco.state.domain.model.State;
import com.unibague.backpsyco.state.infraestructure.driveradapter.StateData;

public class StateMapper {

    public StateData mapStateToStateData(State state) {
        StateData stateData = new StateData();
        stateData.setId(state.getId());
        stateData.setState(state.getState());
        return stateData;
    }

    public State mapStateDataToState(StateData stateData) {
        State state = new State();
        state.setId(stateData.getId());
        state.setState(stateData.getState());
        return state;
    }
}