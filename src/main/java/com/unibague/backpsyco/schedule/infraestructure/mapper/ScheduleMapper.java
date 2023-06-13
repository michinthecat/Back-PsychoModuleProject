package com.unibague.backpsyco.schedule.infraestructure.mapper;

import com.unibague.backpsyco.psychologist.infraestructure.driveradapter.PsychologistData;
import com.unibague.backpsyco.schedule.domain.model.Schedule;
import com.unibague.backpsyco.schedule.infraestructure.driveradapter.ScheduleData;
import com.unibague.backpsyco.state.infraestructure.driveradapter.StateData;

public class ScheduleMapper {
    public static Schedule fromData(ScheduleData data) {

        return new Schedule(
                data.getId(),
                data.getDate(),
                data.getTime(),
                data.getPsychologist().getId(),
                data.getState().getId()
        );
    }

    public static ScheduleData toData(Schedule model) {
        PsychologistData psychologistData = new PsychologistData();
        psychologistData.setId(model.getPsychologist());

        StateData stateData = new StateData();
        stateData.setId(model.getState());

        ScheduleData data = new ScheduleData();
        data.setId(model.getId());
        data.setDate(model.getDate());
        data.setTime(model.getTime());
        data.setPsychologist(psychologistData);
        data.setState(stateData);

        return data;
    }

}
