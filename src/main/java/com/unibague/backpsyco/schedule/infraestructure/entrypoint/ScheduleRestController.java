package com.unibague.backpsyco.schedule.infraestructure.entrypoint;

import com.unibague.backpsyco.schedule.domain.model.Schedule;
import com.unibague.backpsyco.schedule.domain.usecase.ScheduleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/schedule")
public class ScheduleRestController {

    private final ScheduleUseCase scheduleUseCase;


    @PostMapping
    public ResponseEntity<Schedule> saveSchedule(@RequestBody Schedule schedule) {
        return ResponseEntity.ok(scheduleUseCase.saveSchedule(schedule));
    }

    @GetMapping("/{psychologistId}/{stateId}")
    public ResponseEntity<List<Schedule>> getScheduleByPsychologistIdAndStateId(@PathVariable int psychologistId, @PathVariable int stateId) {
        List<Schedule> schedules = scheduleUseCase.getScheduleByPsychologistIdAndStateId(psychologistId, stateId);
        if (schedules.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

}