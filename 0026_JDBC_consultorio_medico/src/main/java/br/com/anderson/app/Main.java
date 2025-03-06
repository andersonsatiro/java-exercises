package br.com.anderson.app;

import br.com.anderson.model.dao.MedicoDAO;
import br.com.anderson.model.dao.PacienteDAO;
import br.com.anderson.model.entities.Medico;
import br.com.anderson.model.entities.Paciente;
import br.com.anderson.utils.ScannerUtil;

import java.util.Scanner;

public class Main  {
    public static void exibirMenu(){
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Sair do programa");
        System.out.println("2 - Cadastrar novo médico");
        System.out.println("3 - Cadastrar novo paciente");
        System.out.println("4 - Buscar médico por matrícula");
        System.out.println("5 - Buscar paciente por CPF");
        System.out.println("6 - Cadastrar uma nova consulta");
        System.out.println("7 - Remover uma consulta cadastrada");
        System.out.println("8 - Atualizar o horário de uma consulta cadastrada");
        System.out.println("9 - Gerar relatórios de consulta");
    }

    public static Medico cadastrarMedico(Scanner sc) {
        Medico medico = new Medico();
        ScannerUtil scannerUtil = new ScannerUtil(sc);
        medico.setNome(scannerUtil.requestString("Digite o nome do médico"));
        medico.setMatricula(scannerUtil.requestInteger("Digite a matrícula do médico"));
        medico.setEspecialidade(scannerUtil.requestString("Digite a especialidade do médico"));
        medico.setSalario(scannerUtil.requestDouble("Digite o salário do médico"));

        return medico;
    }

    public static Paciente cadastrarPaciente(Scanner sc) {
        Paciente paciente = new Paciente();
        ScannerUtil scannerUtil = new ScannerUtil(sc);
        paciente.setNome(scannerUtil.requestString("Digite o nome do paciente"));
        paciente.setCpf(scannerUtil.requestString("Digite o CPF do paciente"));
        paciente.setDoenca(scannerUtil.requestString("Digite a doença do paciente"));

        return paciente;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            exibirMenu();
            ScannerUtil scannerUtil = new ScannerUtil(sc);
            int option = scannerUtil.requestInteger("Digite aqui");

            switch(option) {
                case 1:
                    System.out.println("Saindo do programa...");
                    sc.close();
                    System.exit(0);
                case 2:
                    MedicoDAO medicoDAO = new MedicoDAO();
                    medicoDAO.cadastrarMedico(cadastrarMedico(sc));
                    break;
                case 3:
                    PacienteDAO pacienteDAO = new PacienteDAO();
                    pacienteDAO.cadastrarPaciente(cadastrarPaciente(sc));
                    break;
                case 4:
                    System.out.println("Buscando médico por matrícula...");
                case 5:
                    System.out.println("Buscar paciente por CPF...");
                case 6:
                    System.out.println("Cadastrar uma nova consulta...");
                case 7:
                    System.out.println("Remover uma consulta cadastrada...");
                case 8:
                    System.out.println("Atualizar o horário de uma consulta cadastrada...");
                case 9:
                    System.out.println("Gerar relatórios de consulta...");
            }
        }
    }
}
