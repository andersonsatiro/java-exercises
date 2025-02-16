package br.com.anderson.app;

import br.com.anderson.model.dao.AlunoDAO;
import br.com.anderson.model.entities.Aluno;

import java.util.List;

public class Main {

    private static int STATUS_REPROVADO = 4;
    private static int STATUS_RECUPERACAO = 7;

    private static String returnStudentStatus(double average) {
        return average <= STATUS_REPROVADO
               ? "reprovado" :
               average < STATUS_RECUPERACAO
               ? "recuperação" : "aprovado";
    }

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao sistema! Estamos buscando os alunos cadastrados...");

        AlunoDAO alunoDAO = new AlunoDAO();
        List<Aluno> alunos = alunoDAO.findStudents();

        alunos.forEach(aluno -> {
            System.out.println("\n----------------------------");
            System.out.println("Aluno " + aluno.getNumero() + ": " + aluno.getNome());
            System.out.println("Curso: " + aluno.getCurso());
            System.out.printf("Notas: %.2f, %.2f, %.2f, %.2f", aluno.getNota1(), aluno.getNota2(), aluno.getNota3(), aluno.getNota4());

            double gradeAverage = (aluno.getNota1() + aluno.getNota2() + aluno.getNota3() + aluno.getNota4()) / 4;
            String status = returnStudentStatus(gradeAverage);

            System.out.printf("\nSituação: %s com média %.2f\n", status, gradeAverage);
            System.out.println("----------------------------\n");
        });
    }
}