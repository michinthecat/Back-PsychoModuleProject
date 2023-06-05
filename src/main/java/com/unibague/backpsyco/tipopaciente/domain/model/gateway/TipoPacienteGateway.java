package com.unibague.backpsyco.tipopaciente.domain.model.gateway;


import com.unibague.backpsyco.tipopaciente.domain.model.TipoPaciente;


import java.util.List;

public interface TipoPacienteGateway {

    public void saveTipoPaciente(TipoPaciente tipoPaciente);

    public List<TipoPaciente> getAllTipoPaciente();
}
