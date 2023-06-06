package com.unibague.backpsyco.appointment.infraestructure.mapper;

import com.unibague.backpsyco.appointment.domain.model.Appointment;
import com.unibague.backpsyco.appointment.infraestructure.driveradapter.AppointmentData;
import com.unibague.backpsyco.service.domain.model.Service;
import com.unibague.backpsyco.psychologist.domain.model.Psychologist;
import com.unibague.backpsyco.patient.domain.model.Patient;
import com.unibague.backpsyco.state.domain.model.State;

import java.sql.Timestamp;

public class AppointmentMapper {
    public static Appointment fromData(AppointmentData data) {
        Appointment appointment = new Appointment();
        appointment.setId(data.getId());
        appointment.setDate(new Timestamp(data.getDate().getTime()));

        Service service = new Service();
        service.setId(data.getService().getId());
        service.setServiceName(data.getService().getServiceName());
        service.setDescription(data.getService().getDescription());
        service.setCost(data.getService().getCost());

        Psychologist psychologist = new Psychologist();
        psychologist.setId(data.getPsychologist().getId());
        psychologist.setName(data.getPsychologist().getName());
        psychologist.setLastName(data.getPsychologist().getLastName());
        psychologist.setEmail(data.getPsychologist().getEmail());
        psychologist.setSpecialtyId(data.getPsychologist().getSpecialty().getId());
        psychologist.setRoleId(data.getPsychologist().getRole().getId());

        Patient patient = new Patient();
        patient.setId(data.getPatient().getId());
        patient.setName(data.getPatient().getName());
        patient.setLastName(data.getPatient().getLastName());
        patient.setEmail(data.getPatient().getEmail());
        patient.setAge(data.getPatient().getAge());
        patient.setPhone(data.getPatient().getPhone());
        patient.setPatientTypeId(data.getPatient().getPatientType().getId());
        patient.setGenderId(data.getPatient().getGender().getId());

        State state = new State();
        state.setId(data.getState().getId());
        state.setState(data.getState().getState());

        appointment.setService(service);
        appointment.setPsychologist(psychologist);
        appointment.setPatient(patient);
        appointment.setState(state);
        return appointment;
    }
}
