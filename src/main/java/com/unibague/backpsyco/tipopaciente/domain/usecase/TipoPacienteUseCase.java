package com.unibague.backpsyco.tipopaciente.domain.usecase;

import com.unibague.backpsyco.tipopaciente.domain.model.TipoPaciente;
import com.unibague.backpsyco.tipopaciente.domain.model.gateway.TipoPacienteGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TipoPacienteUseCase {

    private final TipoPacienteGateway tipoPacienteGateway;

    //Logica de negocio
    public void saveTipoPaciente(TipoPaciente tipoPaciente){
        if(tipoPaciente == null){
            throw new RuntimeException("El tipo de paciente no puede ser nulo");
        }
        if(tipoPaciente.getTipo().isEmpty())
        {
            throw new RuntimeException("El tipo de paciente no puede ser vacio");
        }
        tipoPacienteGateway.saveTipoPaciente(tipoPaciente);

    }

     public List<TipoPaciente> getAllTipoPaciente() {
         return tipoPacienteGateway.getAllTipoPaciente();
     }

}
