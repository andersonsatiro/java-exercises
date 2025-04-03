package br.com.anderson.model.dao;

import br.com.anderson.model.entities.Endereco;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoDAO extends AbstractDAO {

    public boolean cadastrarEndereco(Endereco endereco) {
        String sql = "insert into endereco (pais, estado, cidade, bairro, rua, numero) values (?, ?, ?, ?, ?, ?)";

        if(endereco == null) return false;

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, endereco.getPais());
            stmt.setString(2, endereco.getEstado());
            stmt.setString(3, endereco.getCidade());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getRua());
            stmt.setInt(6, endereco.getNumero());
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            return false;
        }
    }
}
