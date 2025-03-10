package br.com.anderson.model.dao;

import br.com.anderson.model.entities.Consulta;
import br.com.anderson.model.entities.Medico;
import br.com.anderson.model.entities.Paciente;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ConsultaDAO extends AbstractDAO {
    public void cadastrarConsulta(Consulta consulta) {
        boolean success = false;

        String sql = "insert into consulta (id_paciente, id_medico, horario, valor) values (?, ?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, consulta.getPaciente().getId());
            stmt.setInt(2, consulta.getMedico().getId());
            stmt.setObject(3, consulta.getHorario());
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

    public LocalDateTime horarioConsultaExists(LocalDateTime horario) {
        String sql = "select horario from consulta where horario = ?";
        Consulta consulta = new Consulta();

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setObject(1, horario);

            var resultSet = stmt.executeQuery();

            if(resultSet.next()) {
                consulta.setHorario(resultSet.getObject("horario", LocalDateTime.class));
                return consulta.getHorario();
            } else {
                return null;
            }
        }catch(SQLException e) {
            return null;
        }
    }

    public boolean removerConsulta(Consulta consulta) {
        boolean success = false;
        String sql = "delete from consulta where id_medico = ? and id_paciente = ? and horario = ?";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, consulta.getMedico().getId());
            stmt.setInt(2, consulta.getPaciente().getId());
            stmt.setObject(3, consulta.getHorario());

            success = stmt.executeUpdate() > 0;
        }catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
            return success;
        }

        return success;
    }
}
