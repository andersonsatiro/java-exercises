import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastrarAluno {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cadastrar_aluno", "root", "@Admin123");
            String sql = "insert into aluno values (?,?,?,?,?,?,?)";

            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, 10);
            stmt.setString(2, "Joao Maria");
            stmt.setString(3, "Informatica");
            stmt.setDouble(4, 8.7);
            stmt.setDouble(5, 7.5);
            stmt.setDouble(6, 9.0);
            stmt.setDouble(7, 4.4);

            int linhasAfetadas = stmt.executeUpdate();

            if(linhasAfetadas > 0){
                System.out.println("Aluno cadastrado com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar o aluno. Tente novamente.");
            }
        } catch(SQLException e) {
            System.err.println("Erro ao cadastrar o aluno. Tente novamente. " + e.getMessage());
        }  finally {
            try {
                if (connection != null) connection.close();
                if (stmt != null) stmt.close();
            } catch(SQLException e) {
                System.err.println("Erro ao fechar a conexao. " + e.getMessage());
            }
        }
    }
}