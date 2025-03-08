package br.com.anderson.app;

import br.com.anderson.model.dao.ConsultaDAO;
import br.com.anderson.model.dao.MedicoDAO;
import br.com.anderson.model.dao.PacienteDAO;
import br.com.anderson.model.entities.Consulta;
import br.com.anderson.model.entities.Medico;
import br.com.anderson.model.entities.Paciente;
import br.com.anderson.utils.DateUtil;
import br.com.anderson.utils.ScannerUtil;

import java.time.LocalDateTime;
import java.util.Scanner;

import static br.com.anderson.utils.DateUtil.stringToDate;

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

    public static void medicoExists(Medico medico){
        if(medico == null) {
            System.out.println("Erro ao buscar o médico. Tente novamente!" + "\n");
        } else if(medico.getId() == 0) {
            System.out.println("Médico não encontrado. Verifique a matrícula e tente novamente." + "\n");
        } else {
            System.out.println("Médico encontrado:");
            System.out.println("Nome: " + medico.getNome());
            System.out.println("Matrícula: " + medico.getMatricula());
            System.out.println("Especialidade: " + medico.getEspecialidade());
            System.out.println("Salário: R$ " + medico.getSalario() + "\n");
        }
    }

    public static void pacienteExists(Paciente paciente) {
        if(paciente == null) {
            System.out.println("Erro ao buscar o paciente. Tente novamente!" + "\n");
        } else if(paciente.getId() == 0) {
            System.out.println("Paciente não encontrado. Verifique o CPF e tente novamente." + "\n");
        } else {
            System.out.println("Paciente encontrado:");
            System.out.println("Nome: " + paciente.getNome());
            System.out.println("CPF: " + paciente.getCpf());
            System.out.println("Doença: " + paciente.getDoenca() + "\n");
        }
    }

    public static Consulta cadastrarConsulta(Scanner sc) {
        Consulta consulta = new Consulta(new Medico(), new Paciente());
        ScannerUtil scannerUtil = new ScannerUtil(sc);

        MedicoDAO medicoDAO = new MedicoDAO();
        consulta.getMedico().setMatricula(scannerUtil.requestInteger("Digite a matrícula do médico"));
        Medico medicoExists = medicoDAO.buscarMedicoByMatricula(consulta.getMedico().getMatricula());

        if(medicoExists.getId() == 0) {
            System.out.println("Não existe nenhum médico cadastrado com essa matrícula. Altere e tente novamente." + "\n");
            return null;
        }

        PacienteDAO pacienteDAO = new PacienteDAO();
        consulta.getPaciente().setCpf(scannerUtil.requestString("Digite o CPF do paciente"));
        Paciente pacienteExists = pacienteDAO.buscarPacienteByCpf(consulta.getPaciente().getCpf());

        if(medicoExists == null || pacienteExists == null) {
            System.out.println("Ocorreu um erro inesperado. Tente novamente." + "\n");
            return null;
        }

        if(pacienteExists.getId() == 0) {
            System.out.println("Não existe nenhum paciente cadastrado com esse CPF. Altere e tente novamenete." + "\n");
            return null;
        }

        LocalDateTime horario = stringToDate(
            scannerUtil.requestString("Digite o horário da consulta (dd/MM/yyyy HH:mm:ss)"),
            LocalDateTime.class
        );

        consulta.getMedico().setId(medicoExists.getId());
        consulta.getPaciente().setId(pacienteExists.getId());
        consulta.setHorario(horario);
        consulta.setValor(scannerUtil.requestDouble("Digite o valor da consulta"));

        return consulta;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            exibirMenu();
            ScannerUtil scannerUtil = new ScannerUtil(sc);

            MedicoDAO medicoDAO = new MedicoDAO();
            PacienteDAO pacienteDAO = new PacienteDAO();
            ConsultaDAO consultaDAO = new ConsultaDAO();

            int option = scannerUtil.requestInteger("Digite aqui");

            switch(option) {
                case 1:
                    System.out.println("Saindo do programa...");
                    sc.close();
                    System.exit(0);
                case 2:
                    medicoDAO.cadastrarMedico(cadastrarMedico(sc));
                    break;
                case 3:
                    pacienteDAO.cadastrarPaciente(cadastrarPaciente(sc));
                    break;
                case 4:
                    medicoExists(
                        medicoDAO.buscarMedicoByMatricula(
                            scannerUtil.requestInteger("Digite a matrícula do médico")
                        )
                    );
                    break;
                case 5:
                    pacienteExists(
                        pacienteDAO.buscarPacienteByCpf(
                            scannerUtil.requestString("Digite o CPF do paciente")
                        )
                    );
                    break;
                case 6:
                    Consulta novaConsulta = cadastrarConsulta(sc);

                    if(novaConsulta != null){
                        consultaDAO.cadastrarConsulta(novaConsulta);
                    }
                    break;
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
