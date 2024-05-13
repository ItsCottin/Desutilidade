package dbmanager;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexao {

    private Connection cn;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/formfam", "root", "");
            return cn;  // Return the connection object
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na Conexão do Banco de Dados", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            return null; // Return null on connection failure
        }
    }
}






