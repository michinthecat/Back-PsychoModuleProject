package com.unibague.backpsyco.schedule.domain.model.gateway;


import com.unibague.backpsyco.schedule.domain.model.Schedule;

import java.util.List;

public interface ScheduleGateway {
    Schedule saveSchedule(Schedule schedule);
    List<Schedule> getScheduleByPsychologistIdAndStateId(int psychologistId, int stateId);

}
