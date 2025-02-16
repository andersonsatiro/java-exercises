package br.com.anderson.model.dao;

import br.com.anderson.model.entities.Aluno;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends AbstractDAO {

    public List<Aluno> findStudents(){
        List<Aluno> alunos = new ArrayList<Aluno>();
        String sql = "select * from aluno";

        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            var rs = stmt.executeQuery();

            while(rs.next()){
                Aluno aluno = new Aluno();
                aluno.setNumero(rs.getInt("numero"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCurso(rs.getString("curso"));
                aluno.setNota1(rs.getDouble("nota1"));
                aluno.setNota2(rs.getDouble("nota2"));
                aluno.setNota3(rs.getDouble("nota3"));
                aluno.setNota4(rs.getDouble("nota4"));
                alunos.add(aluno);
            }

        }catch (SQLException e){
            return null;
        }

        return alunos;
    }
}
