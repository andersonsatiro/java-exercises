package br.com.anderson.model.dao;

import br.com.anderson.model.entities.Paciente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteDAO extends AbstractDAO {
    public void cadastrarPaciente(Paciente paciente) {
        boolean success = false;
        String sql = "insert into paciente (nome, cpf, doenca) values (?, ?, ?)";

        try(PreparedStatement ptmt = connection.prepareStatement(sql)){
            ptmt.setString(1, paciente.getNome());
            ptmt.setString(2, paciente.getCpf());
            ptmt.setString(3, paciente.getDoenca());

            success = ptmt.executeUpdate() > 0;
        } catch(SQLException e) {
            success = false;
        }

        if(success){
            System.out.println("Paciente cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar paciente. Tente novamente!");
        }
    }

    public Paciente buscarPacienteByCpf(String cpf) {
        Paciente paciente = new Paciente();
        String sql = "select * from paciente where cpf = ?";

        try(PreparedStatement ptmt = connection.prepareStatement(sql)){
            ptmt.setString(1, cpf);

            var resultSet = ptmt.executeQuery();

            while(resultSet.next()) {
                paciente.setId(resultSet.getInt("id"));
                paciente.setNome(resultSet.getString("nome"));
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setDoenca(resultSet.getString("doenca"));
            }
        } catch(SQLException e){
            return null;
        }

        return paciente;
    }
}
