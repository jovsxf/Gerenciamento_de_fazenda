package database;

import Geral.*;

import java.sql.SQLException;

public class PragasBD extends ConnectionBD{

    // ----------------------------CRIANDO PRAGAS----------------------------
    public boolean insertPragas(Praga praga){
        connect();
        String sql = "INSERT INTO Pragas(tipo, forca) VALUES(?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, praga.getTipo());
            pst.setInt(2, praga.getForca());
            pst.execute();                           // executa o comando
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

}
