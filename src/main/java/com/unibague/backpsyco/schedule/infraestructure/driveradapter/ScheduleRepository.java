package com.unibague.backpsyco.schedule.infraestructure.driveradapter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<ScheduleData, Integer> {
}
