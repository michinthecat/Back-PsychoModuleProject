package com.unibague.backpsyco.appointment.infraestructure.driveradapter;

import com.unibague.backpsyco.appointment.domain.model.Appointment;
import com.unibague.backpsyco.appointment.domain.model.gateway.AppointmentGateway;
import com.unibague.backpsyco.appointment.infraestructure.mapper.AppointmentMapper;
import com.unibague.backpsyco.email.model.EmailAppointment;
import com.unibague.backpsyco.email.service.MailService;
import com.unibague.backpsyco.state.infraestructure.driveradapter.StateData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class AppointmentAdapterRepository implements AppointmentGateway {

    private final AppointmentRepository appointmentRepository;
    private final MailService mailService;

    @Override
    public List<Appointment> getAppointmentsByDateAndPsychologistId(Date date, int psychologistId) {
        try {
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDateTime startOfDay = localDate.atStartOfDay();
            LocalDateTime endOfDay = localDate.atTime(LocalTime.MAX);

            Date startDate = Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
            Date endDate = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());

            return getAppointmentsByDateRangeAndPsychologistId(startDate, endDate, psychologistId);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener las citas por fecha y ID de psicólogo", e);
        }
    }

    @Override
    public List<Appointment> getAppointmentsByDateRangeAndPsychologistId(Date startDate, Date endDate, int psychologistId) {
        try {
            return appointmentRepository.findByDateBetweenAndPsychologistId(startDate, endDate, psychologistId)
                    .stream()
                    .map(AppointmentMapper::fromData)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener las citas por rango de fechas y ID de psicólogo", e);
        }
    }

    @Override
    public Appointment getAppointmentById(int appointmentId) {
        try {
            return AppointmentMapper.fromData(appointmentRepository.findById(appointmentId)
                    .orElseThrow(() -> new IllegalArgumentException("ID de cita no válido: " + appointmentId)));
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la cita por ID", e);
        }
    }

    @Override
    public Appointment rescheduleAppointment(int appointmentId, LocalDateTime newDateTime) {
        try {
            AppointmentData appointmentData = appointmentRepository.findById(appointmentId)
                    .orElseThrow(() -> new IllegalArgumentException("ID de cita no válido: " + appointmentId));

            Date newDate = Date.from(newDateTime.atZone(ZoneId.systemDefault()).toInstant());

            appointmentData.setDate(newDate);

            EmailAppointment emailAppointment = new EmailAppointment();
            emailAppointment.setName(appointmentData.getPatient().getName());
            emailAppointment.setPsychologist(appointmentData.getPsychologist().getName() + " " + appointmentData.getPsychologist().getLastName());
            emailAppointment.setDate(newDateTime.toLocalDate().toString());
            emailAppointment.setTime(newDateTime.toLocalTime().toString());
            emailAppointment.setAppointmentId(String.valueOf(appointmentId));
            emailAppointment.setEmail(appointmentData.getPatient().getEmail());

            mailService.emailChangeAppointment(emailAppointment);

            return AppointmentMapper.fromData(appointmentRepository.save(appointmentData));
        } catch (Exception e) {
            throw new RuntimeException("Error al reprogramar la cita", e);
        }
    }

    @Override
    public boolean cancelAppointment(int appointmentId) {
        try {
            AppointmentData appointmentData = appointmentRepository.findById(appointmentId)
                    .orElseThrow(() -> new IllegalArgumentException("ID de cita no válido: " + appointmentId));

            StateData cancelledState = new StateData();
            cancelledState.setId(3);

            appointmentData.setState(cancelledState);

            EmailAppointment emailAppointment = new EmailAppointment();
            emailAppointment.setName(appointmentData.getPatient().getName());
            emailAppointment.setPsychologist(appointmentData.getPsychologist().getName() + " " + appointmentData.getPsychologist().getLastName());
            emailAppointment.setDate(appointmentData.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString());
            emailAppointment.setTime(appointmentData.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalTime().toString());
            emailAppointment.setAppointmentId(String.valueOf(appointmentId));
            emailAppointment.setEmail(appointmentData.getPatient().getEmail());

            mailService.emailCancelationAppointment(emailAppointment);

            appointmentRepository.save(appointmentData);

            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error al cancelar la cita", e);
        }
    }
}
