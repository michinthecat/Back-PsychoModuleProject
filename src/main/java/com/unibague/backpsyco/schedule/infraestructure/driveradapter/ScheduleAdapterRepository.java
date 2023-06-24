package com.unibague.backpsyco.schedule.infraestructure.driveradapter;


import com.unibague.backpsyco.schedule.domain.model.Schedule;
import com.unibague.backpsyco.schedule.domain.model.gateway.ScheduleGateway;

import com.unibague.backpsyco.schedule.infraestructure.mapper.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class ScheduleAdapterRepository implements ScheduleGateway {

    private final ScheduleRepository scheduleRepository;

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        try {
            ScheduleData scheduleData = ScheduleMapper.toData(schedule);
            ScheduleData savedScheduleData = scheduleRepository.save(scheduleData);
            return ScheduleMapper.fromData(savedScheduleData);
        } catch (DataAccessException ex) {
            throw new DataAccessException("Error al guardar el horario") {
            };
        }
    }

    @Override
    public List<Schedule> getScheduleByPsychologistIdAndStateId(int psychologistId, int stateId) {
        List<ScheduleData> scheduleDataList = scheduleRepository.findByPsychologistIdAndStateId(psychologistId, stateId);
        return scheduleDataList.stream()
                .map(ScheduleMapper::fromData)
                .collect(Collectors.toList());
    }

    @Override
    public List<Schedule> getScheduleByPsychologistIdAndDate(int psychologistId, LocalDate date) {
        List<ScheduleData> scheduleDataList = scheduleRepository.findByPsychologistIdAndDate(psychologistId, date);
        return scheduleDataList.stream()
                .map(ScheduleMapper::fromData)
                .collect(Collectors.toList());
    }


}
