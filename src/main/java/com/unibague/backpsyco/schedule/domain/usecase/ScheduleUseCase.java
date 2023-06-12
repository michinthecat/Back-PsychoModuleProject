package com.unibague.backpsyco.schedule.domain.usecase;

import com.unibague.backpsyco.schedule.domain.model.Schedule;
import com.unibague.backpsyco.schedule.domain.model.gateway.ScheduleGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ScheduleUseCase {

    private final ScheduleGateway scheduleGateway;

    public Schedule saveSchedule(Schedule schedule){
        return scheduleGateway.saveSchedule(schedule);
    }

    public List<Schedule> getScheduleByPsychologistIdAndStateId(int psychologistId, int stateId){
        return scheduleGateway.getScheduleByPsychologistIdAndStateId(psychologistId, stateId);
    }


}
