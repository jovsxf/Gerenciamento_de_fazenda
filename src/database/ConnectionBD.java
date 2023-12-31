package database;

import java.sql.*;
public class ConnectionBD {
    java.sql.Connection connection;   // objeto responsável por fazer a conexão com o servidor do MySQL
    Statement statement;     // objeto responsável por preparar consultas "SELECT"
    ResultSet result;        // objeto responsável por executar consultas "SELECT"
    PreparedStatement pst;   // objeto responsável por preparar querys de manipulação dinâmicas (INSERT, UPDATE, DELETE)

    static final String user = "root";                  // usuário da instância local do servidor
    static final String password = "290504";    // senha do usuário da instância local do servidor
    static final String database = "mydb";           // nome do banco de dados a ser utilizado

    // string com URL de conexão com servidor
    static final String url = "jdbc:mysql://127.0.0.1:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";

    protected boolean check = false;       // variável interna para confirmação de métodos do CRUD

    public void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            //System.out.println("Conexão feita com sucesso: " + connection); Comentado para não atrapalhar o console
        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }
}
