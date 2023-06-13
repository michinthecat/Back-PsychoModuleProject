package com.unibague.backpsyco.service.infraestructure.driveradapter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceData, Integer> {
}
