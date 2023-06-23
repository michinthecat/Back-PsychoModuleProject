package com.unibague.backpsyco.tipopaciente.application;

import com.unibague.backpsyco.appointment.domain.model.gateway.AppointmentGateway;
import com.unibague.backpsyco.appointment.domain.usecase.AppointmentUseCase;
import com.unibague.backpsyco.gender.domain.model.gateway.GenderGateway;
import com.unibague.backpsyco.gender.domain.usecase.GenderUseCase;
import com.unibague.backpsyco.patient.domain.model.gateway.PatientGateway;
import com.unibague.backpsyco.patient.domain.usecase.PatientUseCase;
import com.unibague.backpsyco.programpatient.domain.model.gateway.ProgramPatientGateway;
import com.unibague.backpsyco.programpatient.domain.usecase.ProgramPatientUseCase;
import com.unibague.backpsyco.psychologist.domain.model.gateway.PsychologistGateway;
import com.unibague.backpsyco.psychologist.domain.usecase.PsychologistUseCase;
import com.unibague.backpsyco.schedule.domain.model.gateway.ScheduleGateway;
import com.unibague.backpsyco.schedule.domain.usecase.ScheduleUseCase;
import com.unibague.backpsyco.service.domain.model.gateway.ServiceGateway;
import com.unibague.backpsyco.service.domain.usecase.ServiceUseCase;
import com.unibague.backpsyco.specialties.domain.model.gateway.SpecialityGateway;
import com.unibague.backpsyco.specialties.domain.usecase.SpecialityUseCase;
import com.unibague.backpsyco.tipopaciente.domain.model.gateway.TipoPacienteGateway;
import com.unibague.backpsyco.tipopaciente.domain.usecase.TipoPacienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public TipoPacienteUseCase tipoPacienteUseCase(TipoPacienteGateway tipoPacienteGateway){
        return new TipoPacienteUseCase(tipoPacienteGateway);
    }

    @Bean
    public AppointmentUseCase appointmentUseCase(AppointmentGateway appointmentGateway){
        return new AppointmentUseCase(appointmentGateway);
    }

    @Bean
    public PatientUseCase patientUseCase(PatientGateway patientGateway){
        return new PatientUseCase(patientGateway);
    }

    @Bean
    public ProgramPatientUseCase programPatientUseCase(ProgramPatientGateway programPatientGateway){
        return new ProgramPatientUseCase(programPatientGateway);
    }
    @Bean
    public PsychologistUseCase psychologistUseCase(PsychologistGateway psychologistGateway){
        return new PsychologistUseCase(psychologistGateway);
    }

    @Bean
    public ScheduleUseCase scheduleUseCase(ScheduleGateway scheduleGateway){
             return new ScheduleUseCase(scheduleGateway);
    }

    @Bean
    public SpecialityUseCase specialityUseCase(SpecialityGateway specialityGateway){
        return new SpecialityUseCase(specialityGateway);
    }

    @Bean
    public ServiceUseCase serviceUseCase(ServiceGateway serviceGateway){
        return new ServiceUseCase(serviceGateway);
    }

    @Bean
    public GenderUseCase genderUseCase(GenderGateway genderGateway)
    {
        return new GenderUseCase(genderGateway);
    }

}
