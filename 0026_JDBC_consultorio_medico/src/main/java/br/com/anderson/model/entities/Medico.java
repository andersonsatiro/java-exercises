package br.com.anderson.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Medico {
    private int id;
    private String nome;
    private int matricula;
    private String especialidade;
    private double salario;
}
