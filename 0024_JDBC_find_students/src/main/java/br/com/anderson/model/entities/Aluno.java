package br.com.anderson.model.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Aluno {
    private int numero;
    private String nome;
    private String curso;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
}
