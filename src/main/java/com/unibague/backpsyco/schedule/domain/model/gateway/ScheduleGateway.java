package com.unibague.backpsyco.schedule.domain.model.gateway;


import com.unibague.backpsyco.schedule.domain.model.Schedule;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleGateway {
    Schedule saveSchedule(Schedule schedule);
    List<Schedule> getScheduleByPsychologistIdAndDate(int psychologistId, LocalDate date);
    void deleteSchedule(int scheduleId);

}
