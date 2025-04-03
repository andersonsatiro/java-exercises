package br.com.anderson.model.dao;

import br.com.anderson.model.entities.Cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO extends AbstractDAO {
    private EnderecoDAO enderecoDAO;

    public void cadastrarCliente(Cliente cliente) {
        boolean success = false;

        if(cliente == null) {
            System.out.println("Cliente não pode ser nulo.");
            return;
        }

        if(!enderecoDAO.cadastrarEndereco(cliente.getEndereco())) {
            System.out.println("Ocorreu um erro inesperado ao cadastrar o endereço do cliente. Revise os dados e tente novamente.");
            return;
        }

        String sql = "insert into cliente (nome, cpf, telefone, email, endereco_id) values (?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {

        } catch(SQLException e) {
            success = false;
        }
    }
}
