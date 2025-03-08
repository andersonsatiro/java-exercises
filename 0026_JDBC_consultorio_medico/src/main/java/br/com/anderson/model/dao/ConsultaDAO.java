package br.com.anderson.model.dao;

import br.com.anderson.model.entities.Consulta;
import br.com.anderson.model.entities.Medico;
import br.com.anderson.model.entities.Paciente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultaDAO extends AbstractDAO {
    public void cadastrarConsulta(Consulta consulta) {
        boolean success = false;
        MedicoDAO medicoDAO = new MedicoDAO();
        PacienteDAO pacienteDAO = new PacienteDAO();

        Medico medicoExists = medicoDAO.buscarMedicoByMatricula(consulta.getMedico().getMatricula());
        Paciente pacienteExists = pacienteDAO.buscarPacienteByCpf(consulta.getPaciente().getCpf());

        if(medicoExists == null || pacienteExists == null) {
            System.out.println("Ocorreu um erro inesperado. Tente novamente." + "\n");
            return;
        }

        if(medicoExists.getId() != 0) {
            System.out.println("Já existe um médico cadastrado com essa matrícula. Altere e tente novamente." + "\n");
            return;
        }

        if(pacienteExists.getId() != 0) {
            System.out.println("Já existe um paciente cadastrado com esse CPF. Altere e tente novamenete." + "\n");
        }


        String sql = "insert into consulta (id_paciente, id_medico, horario, valor) values (?, ?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, consulta.getPaciente().getId());
            stmt.setInt(2, consulta.getMedico().getId());
            stmt.setString(3, consulta.getHorario());
            stmt.setDouble(4, consulta.getValor());

            success = stmt.executeUpdate() > 0;
        } catch(SQLException e) {
            success = false;
        }

        if(success){
            System.out.println("Consulta cadastrada com sucesso!" + "\n");
        } else {
            System.out.println("Erro ao cadastrar consulta. Tente novamente." + "\n");
        }
    }
}
