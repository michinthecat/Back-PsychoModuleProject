package com.unibague.backpsyco.psychologist.infraestructure.driveradapter;

import com.unibague.backpsyco.schedule.infraestructure.driveradapter.ScheduleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PsychologistRepository extends JpaRepository<PsychologistData, Integer> {


}
