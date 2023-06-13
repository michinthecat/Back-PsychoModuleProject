package com.unibague.backpsyco.state.domain.model.gateway;

import com.unibague.backpsyco.state.domain.model.State;


public interface StateGateway {

    State findByName(String name);
}
