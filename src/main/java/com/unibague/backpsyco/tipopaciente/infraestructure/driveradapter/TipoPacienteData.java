package com.unibague.backpsyco.tipopaciente.infraestructure.driveradapter;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "tipo_paciente")
@Data
public class TipoPacienteData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tipo", nullable = false)
    private String tipo;
}
