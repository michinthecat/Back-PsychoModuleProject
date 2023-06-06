package com.unibague.backpsyco.appointment.infraestructure.driveradapter;
import com.unibague.backpsyco.state.infraestructure.driveradapter.StateData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentData, Integer> {


    List<AppointmentData> findByPsychologistId(int psychologist_id);
    List<AppointmentData> findByDateAndPsychologistId(Date date, int psychologist_id);
    List<AppointmentData> findByPatientIdAndPsychologistId(int patient_id, int psychologist_id);
    List<AppointmentData> findByStateAndPsychologistId(StateData state, int psychologist_id);
    List<AppointmentData> findByDateBetweenAndPsychologistId(Date startDate, Date endDate, int psychologistId);


}