package database;

import Geral.*;

import java.sql.SQLException;


public class SoloBD extends ConnectionBD{

    // ----------------------------CRIANDO SOLO----------------------------
    public boolean insertSolo(Solo solo){
     super.connect();
        String sql = "INSERT INTO Solo(idSolo, nivelDePh) VALUES(?, ?)";
        try {
            this.pst = connection.prepareStatement(sql);
            pst.setInt(1, solo.getIdSolo());
            pst.setFloat(2, solo.getNivelDePh());
            pst.execute();                           // executa o comando
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
            check = false;
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
}
