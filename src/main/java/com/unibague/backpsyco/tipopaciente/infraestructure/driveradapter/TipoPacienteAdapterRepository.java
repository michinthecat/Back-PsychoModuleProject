package com.unibague.backpsyco.tipopaciente.infraestructure.driveradapter;

import com.unibague.backpsyco.tipopaciente.domain.model.TipoPaciente;
import com.unibague.backpsyco.tipopaciente.domain.model.gateway.TipoPacienteGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class TipoPacienteAdapterRepository implements TipoPacienteGateway {

    private final TipoPacienteRepository tipoPacienteRepository;

    @Override
    public void saveTipoPaciente(TipoPaciente tipoPaciente) {

        TipoPacienteData tipoPacienteData = new TipoPacienteData();
        tipoPacienteData.setId(tipoPaciente.getId());
        tipoPacienteData.setTipo(tipoPaciente.getTipo());
        tipoPacienteRepository.save(tipoPacienteData);
    }

    @Override
    public List<TipoPaciente> getAllTipoPaciente() {

        return tipoPacienteRepository.findAll().stream()
                .map(tipoPacienteData -> new TipoPaciente(tipoPacienteData.getId(), tipoPacienteData.getTipo()))
                .collect(Collectors.toList());

    }
}
