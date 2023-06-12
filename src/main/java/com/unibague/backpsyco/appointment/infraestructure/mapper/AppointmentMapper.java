package com.unibague.backpsyco.appointment.infraestructure.mapper;

import com.unibague.backpsyco.appointment.domain.model.Appointment;
import com.unibague.backpsyco.appointment.infraestructure.driveradapter.AppointmentData;
import com.unibague.backpsyco.gender.domain.model.Gender;
import com.unibague.backpsyco.patienttype.domain.model.PatientType;
import com.unibague.backpsyco.role.domain.model.Role;
import com.unibague.backpsyco.service.domain.model.Service;
import com.unibague.backpsyco.psychologist.domain.model.Psychologist;
import com.unibague.backpsyco.patient.domain.model.Patient;
import com.unibague.backpsyco.specialties.domain.model.Specialty;
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

        Specialty specialty = new Specialty();
        specialty.setId(data.getPsychologist().getSpecialty().getId());
        specialty.setSpecialty(data.getPsychologist().getSpecialty().getSpecialty());
        psychologist.setSpecialty(specialty);

        Role role = new Role();
        role.setId(data.getPsychologist().getRole().getId());
        role.setRole(data.getPsychologist().getRole().getRole());
        psychologist.setRole(role);


        Patient patient = new Patient();
        patient.setId(data.getPatient().getId());
        patient.setName(data.getPatient().getName());
        patient.setLastName(data.getPatient().getLastName());
        patient.setEmail(data.getPatient().getEmail());
        patient.setAge(data.getPatient().getAge());
        patient.setPhone(data.getPatient().getPhone());

        PatientType patientType = new PatientType();
        patientType.setId(data.getPatient().getPatientType().getId());
        patientType.setPatientType(data.getPatient().getPatientType().getType());
        patient.setPatientType(patientType);

        Gender gender = new Gender();
        gender.setId(data.getPatient().getGender().getId());
        gender.setGender(data.getPatient().getGender().getGender());
        patient.setGender(gender);

        patient.setNotes(data.getPatient().getNotes());

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
