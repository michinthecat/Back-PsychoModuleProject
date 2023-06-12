package com.unibague.backpsyco.schedule.infraestructure.driveradapter;


import com.unibague.backpsyco.schedule.domain.model.Schedule;
import com.unibague.backpsyco.schedule.domain.model.gateway.ScheduleGateway;

import com.unibague.backpsyco.schedule.infraestructure.mapper.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class ScheduleAdapterRepository implements ScheduleGateway {

    private final ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll().stream()
                .map(ScheduleMapper::fromData)
                .collect(Collectors.toList());
    }

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        ScheduleData scheduleData = ScheduleMapper.toData(schedule);
        ScheduleData savedScheduleData = scheduleRepository.save(scheduleData);
        return ScheduleMapper.fromData(savedScheduleData);
    }
}
