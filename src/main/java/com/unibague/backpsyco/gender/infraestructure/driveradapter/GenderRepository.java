package com.unibague.backpsyco.gender.infraestructure.driveradapter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<GenderData, Integer> {
}
