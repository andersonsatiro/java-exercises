package br.com.anderson.model.dao;

import br.com.anderson.model.entities.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO extends AbstractDAO {
    private EnderecoDAO enderecoDAO = new EnderecoDAO();

    public boolean cadastrarCliente(Cliente cliente) {
        boolean success = false;

        if(cliente == null) {
            System.out.println("Cliente não pode ser nulo.");
            return false;
        }

        int enderecoId = enderecoDAO.cadastrarEndereco(cliente.getEndereco());
        if(enderecoId < 0) return false;

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
            success = false;
        }

        return success;
    }

    public Cliente buscarClienteByCpf(String cpf) {
        String sql = "select id, nome, email from cliente where cpf = ?";
        Cliente cliente = new Cliente();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                cliente.setId(id);
                cliente.setNome(nome);
                cliente.setCpf(cpf);
                cliente.setEmail(email);
            }
        } catch(SQLException e) {
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
        }

        return cliente;
    }
}
