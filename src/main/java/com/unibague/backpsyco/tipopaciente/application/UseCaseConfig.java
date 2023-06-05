package com.unibague.backpsyco.tipopaciente.application;

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

}
