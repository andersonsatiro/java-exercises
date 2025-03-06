package br.com.anderson.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private String horario;
    private double valor;
}
