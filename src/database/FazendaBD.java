package database;

import Geral.*;
import Maquinario.*;
import Plantacao.Cafe;

import java.sql.SQLException;
import java.util.ArrayList;

import static javax.management.remote.JMXConnectorFactory.connect;


public class FazendaBD extends ConnectionBD {

        // ----------------------------CRIANDO FAZENDA----------------------------
        public boolean insertFazenda(Fazenda fazenda){
            connect();
            String sql = "INSERT INTO Fazenda(nome, hectaresTotais, hectaresParaPlantio, numeroDoMesAtual, numPragas, numFunc) VALUES(?, ?, ?, ?, ?, ?)";
            try {
                pst = connection.prepareStatement(sql);
                pst.setString(1, fazenda.getNome());
                pst.setInt(2,fazenda.getHectaresTotais());
                pst.setInt(3,fazenda.getHectaresParaPlantio());
                pst.setInt(4,fazenda.getNumeroDoMesAtual());
                pst.setInt(5,fazenda.getNumPragas());
                pst.setInt(6,fazenda.getNumFunc());
                pst.execute();                           // executa o comando
                check = true;
                //Inserindo na tabela de fazenda
            } catch (SQLException e) {
                System.out.println("Erro ao criar fazenda: " + e.getMessage());
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

        // ----------------------------ATUALIZANDO NUMERO DO MES----------------------------
        public boolean updateFazenda(Fazenda fazenda, int NumeroDoMesAtual){
            connect();
            String sql = "UPDATE Fazenda SET NumeroDoMesAtual = ? WHERE nome = ?";
            try {
                pst = connection.prepareStatement(sql);
                pst.setInt(1, NumeroDoMesAtual);
                pst.setString(2, fazenda.getNome());
                pst.execute();                           // executa o comando
                check = true;

            }catch (SQLException e) {
                System.out.println("Erro ao criar conexão: " + e.getMessage());
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
