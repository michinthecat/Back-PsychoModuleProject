package com.unibague.backpsyco.state.infraestructure.driveradapter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<StateData, Integer> {
}
