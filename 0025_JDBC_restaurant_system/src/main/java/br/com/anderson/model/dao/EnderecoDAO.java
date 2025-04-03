package br.com.anderson.model.dao;

import br.com.anderson.model.entities.Endereco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnderecoDAO extends AbstractDAO {

    public int cadastrarEndereco(Endereco endereco) {
        String sql = "insert into endereco (pais, estado, cidade, bairro, rua, numero) values (?, ?, ?, ?, ?, ?)";

        if(endereco == null) return -1;

        try(PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, endereco.getPais());
            stmt.setString(2, endereco.getEstado());
            stmt.setString(3, endereco.getCidade());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getRua());
            stmt.setInt(6, endereco.getNumero());

            int linhasAfetadas = stmt.executeUpdate();

            if(linhasAfetadas > 0) {
                try(ResultSet chave = stmt.getGeneratedKeys()) {
                    if(chave.next()) {
                        return chave.getInt(1);
                    }

                }
            }

        }catch(SQLException e){
            System.out.println("Ocorreu um erro ao cadastrar o endereço: " + e.getMessage());
        }

        return -1;
    }
}
