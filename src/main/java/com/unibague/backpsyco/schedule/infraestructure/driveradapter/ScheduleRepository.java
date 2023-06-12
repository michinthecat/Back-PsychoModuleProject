package com.unibague.backpsyco.schedule.infraestructure.driveradapter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleData, Integer> {
    List<ScheduleData> findByPsychologistIdAndStateId(int psychologistId, int stateId);
}
