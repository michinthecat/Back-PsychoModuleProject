package com.unibague.backpsyco.schedule.infraestructure.mapper;


import com.unibague.backpsyco.psychologist.domain.model.Psychologist;
import com.unibague.backpsyco.psychologist.infraestructure.driveradapter.PsychologistData;
import com.unibague.backpsyco.role.domain.model.Role;
import com.unibague.backpsyco.schedule.domain.model.Schedule;
import com.unibague.backpsyco.schedule.infraestructure.driveradapter.ScheduleData;
import com.unibague.backpsyco.specialties.domain.model.Specialty;
import com.unibague.backpsyco.state.domain.model.State;
import com.unibague.backpsyco.state.infraestructure.driveradapter.StateData;

public class ScheduleMapper {
    public static Schedule fromData(ScheduleData data) {
        Psychologist psychologist = new Psychologist();
        psychologist.setId(data.getPsychologist().getId());
        psychologist.setName(data.getPsychologist().getName());
        psychologist.setLastName(data.getPsychologist().getLastName());
        psychologist.setEmail(data.getPsychologist().getEmail());

        State state = new State();
        state.setId(data.getState().getId());
        state.setState(data.getState().getState());

        return new Schedule(
                data.getId(),
                data.getDate(),
                data.getTime(),
                psychologist,
                state
        );
    }

    public static ScheduleData toData(Schedule model) {
        PsychologistData psychologistData = new PsychologistData();
        psychologistData.setId(model.getPsychologist().getId());
        psychologistData.setName(model.getPsychologist().getName());
        psychologistData.setLastName(model.getPsychologist().getLastName());
        psychologistData.setEmail(model.getPsychologist().getEmail());

        StateData stateData = new StateData();
        stateData.setId(model.getState().getId());
        stateData.setState(model.getState().getState());

        ScheduleData data = new ScheduleData();
        data.setId(model.getId());
        data.setDate(model.getDate());
        data.setTime(model.getTime());
        data.setPsychologist(psychologistData);
        data.setState(stateData);

        return data;
    }

}
