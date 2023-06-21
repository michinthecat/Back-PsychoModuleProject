package com.unibague.backpsyco.appointment.infraestructure.driveradapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentData, Integer> {

    List<AppointmentData> findByDateAndPsychologistId(Date date, int psychologist_id);
    List<AppointmentData> findByDateBetweenAndPsychologistId(Date startDate, Date endDate, int psychologistId);


}