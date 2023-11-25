package database;

import Maquinario.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class MaquinarioBD extends ConnectionBD{

    // ----------------------------CRIANDO MAQUINARIO----------------------------
    public boolean insertMaquinario(Maquinario maquinario){
        connect();
        String sql = "INSERT INTO Maquinário(numerodeserie, uso) VALUES(?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,maquinario.getNumeroDeSerie());
            pst.setBoolean(2,maquinario.isUso());
            pst.execute();                           // executa o comando
            check = true;
            //Inserindo na tabela de maquinario
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

    // ----------------------------DELETANDO MAQUINARIO----------------------------
    public ArrayList<Maquinario> deleteMaquinario(Maquinario maquinario){
        connect();
        ArrayList<Maquinario> maquinarios = new ArrayList<>();
        String sql = "DELETE FROM Maquinário WHERE numerodeserie = ?";
        try{
            statement = connection.createStatement();
            pst.setString(1,maquinario.getNumeroDeSerie());
            result = statement.executeQuery(sql);
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return maquinarios;
    }
}
