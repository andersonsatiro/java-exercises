package br.com.anderson.app;

import br.com.anderson.model.dao.AlunoDAO;
import br.com.anderson.model.entities.Aluno;
import br.com.anderson.utils.ScannerUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ScannerUtil scannerUtil = new ScannerUtil(sc);
        System.out.println("Olá, seja bem-vindo ao sistema de cadastramento de alunos!");

        while(true){
            System.out.println();

            Aluno aluno = new Aluno();
            aluno.setNumero(scannerUtil.requestInteger("Digite o número de identificação do aluno"));
            aluno.setNome(scannerUtil.requestString("Digite o nome do aluno"));
            aluno.setCurso(scannerUtil.requestString("Digite o curso do aluno"));
            aluno.setNota1(scannerUtil.requestDouble("Digite a primeira nota"));
            aluno.setNota2(scannerUtil.requestDouble("Digite a segunda nota"));
            aluno.setNota3(scannerUtil.requestDouble("Digite a terceira nota"));
            aluno.setNota4(scannerUtil.requestDouble("Digite a quarta nota"));

            AlunoDAO alunoDAO = new AlunoDAO();
            if(alunoDAO.adicionar(aluno)) {
                System.out.println("Aluno(a) " + aluno.getNome() + " foi cadastrado(a) com sucesso!");
            }  else {
                System.out.println("Ocorreu um erro ao cadastrar aluno(a) " + aluno.getNome() + ". Tente novamente!");
            }

            int option = scannerUtil.requestInteger("\nCaso deseje inserir um novo aluno digite 1. Caso contrário, digite qualquer outro número para finalizar o programa");

            if(option != 1)
                break;
        }
        sc.close();
    }
}