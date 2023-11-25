package database;

import Geral.*;

import java.sql.SQLException;

public class FuncionariosBD extends ConnectionBD{

    // ----------------------------CRIANDO FUNCIONÁRIO----------------------------
    public boolean insertFuncionarios(Funcionarios funcionarios){
        connect();
        String sql = "INSERT INTO Funcionários(nome, cpf, idade) VALUES(?, ?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, funcionarios.getNome());
            pst.setString(2, funcionarios.getCpf());
            pst.setInt(3, funcionarios.getIdade());
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
