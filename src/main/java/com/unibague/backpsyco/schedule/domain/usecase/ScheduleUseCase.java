package com.unibague.backpsyco.schedule.domain.usecase;

import com.unibague.backpsyco.schedule.domain.model.Schedule;
import com.unibague.backpsyco.schedule.domain.model.gateway.ScheduleGateway;
import com.unibague.backpsyco.schedule.infraestructure.driveradapter.ScheduleRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ScheduleUseCase {

    private final ScheduleGateway scheduleGateway;

    public List<Schedule> getAllSchedules() {
        return scheduleGateway.getAllSchedules();
    }

    public Schedule saveSchedule(Schedule schedule){
        return scheduleGateway.saveSchedule(schedule);
    }


}
