package com.unibague.backpsyco.tipopaciente.application;

import com.unibague.backpsyco.appointment.domain.model.gateway.AppointmentGateway;
import com.unibague.backpsyco.appointment.domain.usecase.AppointmentUseCase;
import com.unibague.backpsyco.patient.domain.model.gateway.PatientGateway;
import com.unibague.backpsyco.patient.domain.usecase.PatientUseCase;
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

}
