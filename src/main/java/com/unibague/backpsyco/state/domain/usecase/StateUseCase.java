package com.unibague.backpsyco.state.domain.usecase;

import com.unibague.backpsyco.state.domain.model.State;
import com.unibague.backpsyco.state.domain.model.gateway.StateGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class StateUseCase {

    private final StateGateway stateGateway;


}
