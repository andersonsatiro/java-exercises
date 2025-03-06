package br.com.anderson.model.dao;

import br.com.anderson.model.entities.Medico;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicoDAO extends AbstractDAO {
    public void cadastrarMedico(Medico medico) {
        boolean success = false;
        String sql = "insert into medico (nome, matricula, especialidade, salario) values (?, ?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, medico.getNome());
            stmt.setInt(2, medico.getMatricula());
            stmt.setString(3, medico.getEspecialidade());
            stmt.setDouble(4, medico.getSalario());

            success = stmt.executeUpdate() > 0;
        } catch(SQLException e){
            success = false;
        }

        if(success){
            System.out.println("Médico cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar médico. Tente novamente!");
        }
    }
}
