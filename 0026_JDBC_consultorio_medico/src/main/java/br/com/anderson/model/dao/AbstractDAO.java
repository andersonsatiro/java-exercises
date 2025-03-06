package br.com.anderson.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDAO {
    protected Connection connection;

    public AbstractDAO() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/consultorio_medico",
                    "root",
                    "@Admin123"
            );
        } catch (SQLException e){
            System.out.println("Ocorreu um erro durante a conexão com o banco de dados.");
        }
    }

    public void closeAbstractDAO() {
        try {
            connection.close();
        } catch(SQLException e) {
            System.out.println("Ocorreu um erro ao fechar a conexão com o banco de dados.");
        }
    }
}
