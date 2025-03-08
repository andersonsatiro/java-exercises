package br.com.anderson.model.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime horario;
    private double valor;

    public Consulta(){}

    public Consulta(Medico medico, Paciente paciente) {
        this.medico = medico;
        this.paciente = paciente;
    }
}
