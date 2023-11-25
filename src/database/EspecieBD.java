package database;

import Plantacao.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class EspecieBD extends ConnectionBD{

    // ----------------------------CRIANDO ESPÉCIE----------------------------
    public boolean insertEspecie(Especie especie){
        connect();
        String sql = "INSERT INTO Espécie(nome, quantidadeDeMudas) VALUES(?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,especie.getNome());
            pst.setInt(2,especie.getQuantidadeDeMudas());
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

    // ----------------------------BUSCANDO ESPÉCIE----------------------------
    public ArrayList<Especie> buscarEspecie(){
        this.connect();
        ArrayList<Especie> especies = new ArrayList<>();
        String sql = "SELECT * FROM Espécie";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(this.result.next()){
                Especie especieaux = new Especie(this.result.getString("nome"), this.result.getInt("QuantidadeDeMudas"));
                especies.add(especieaux);
            }
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
        return especies;
    }
}
