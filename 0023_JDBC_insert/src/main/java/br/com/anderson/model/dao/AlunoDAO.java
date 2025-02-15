package br.com.anderson.model.dao;

import br.com.anderson.model.entities.Aluno;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDAO extends AbstractDAO {
    public boolean adicionar(Aluno aluno){
        boolean success;
        String sql = "insert into aluno VALUES (?, ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, aluno.getNumero());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getCurso());
            stmt.setDouble(4, aluno.getNota1());
            stmt.setDouble(5, aluno.getNota2());
            stmt.setDouble(6, aluno.getNota3());
            stmt.setDouble(7, aluno.getNota4());

            success = stmt.executeUpdate() == 1;
        }catch (SQLException e){
            success = false;
        }

        return success;
    }
}
