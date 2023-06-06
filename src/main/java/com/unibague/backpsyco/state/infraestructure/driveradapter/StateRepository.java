package com.unibague.backpsyco.state.infraestructure.driveradapter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StateRepository extends JpaRepository<StateData, Integer> {
    Optional<StateData> findByState(String state);




}
