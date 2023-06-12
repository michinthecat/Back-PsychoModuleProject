package com.unibague.backpsyco.schedule.domain.model.gateway;


import com.unibague.backpsyco.schedule.domain.model.Schedule;

import java.util.List;

public interface ScheduleGateway {

    List<Schedule> getAllSchedules();
    Schedule saveSchedule(Schedule schedule);

}
