package com.unibague.backpsyco.tipopaciente.infraestructure.entrypoint;

import com.unibague.backpsyco.tipopaciente.domain.model.TipoPaciente;
import com.unibague.backpsyco.tipopaciente.domain.usecase.TipoPacienteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tipopaciente")
public class TipoPacienteRestController {

    private final TipoPacienteUseCase tipoPacienteUseCase;


    @PostMapping
    public void saveTipoPaciente(@RequestBody TipoPaciente tipoPaciente){

        tipoPacienteUseCase.saveTipoPaciente(tipoPaciente);
    }






}
