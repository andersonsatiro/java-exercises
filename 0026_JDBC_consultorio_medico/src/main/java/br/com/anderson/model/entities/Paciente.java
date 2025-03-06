package br.com.anderson.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paciente {
    private int id;
    private String nome;
    private String cpf;
    private String doenca;
}
