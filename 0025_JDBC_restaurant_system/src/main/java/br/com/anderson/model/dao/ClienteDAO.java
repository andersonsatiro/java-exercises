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

        int enderecoId = enderecoDAO.cadastrarEndereco(cliente.getEndereco());
        if(enderecoId < 0) return;

        String sql = "insert into cliente (nome, cpf, telefone, email, endereco_id) values (?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setInt(5, enderecoId);

            success = stmt.executeUpdate() > 0;

            if(success) {
                System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar o cliente " + cliente.getNome() + ". Verifique os dados e tente novamente.");
            }

        } catch(SQLException e) {
            System.out.println("Ocorreu um erro ao cadastrar o cliente: " + e.getMessage());
            return;
        }
    }
}
