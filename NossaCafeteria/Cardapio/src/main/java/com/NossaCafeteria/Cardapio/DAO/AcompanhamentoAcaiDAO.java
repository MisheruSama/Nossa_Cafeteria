package com.NossaCafeteria.Cardapio.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.NossaCafeteria.Cardapio.Model.AcompanhamentoAcai;

@Repository

public class AcompanhamentoAcaiDAO extends GenericDAO<AcompanhamentoAcai,Integer>{
    @Override
    public List<AcompanhamentoAcai> obterTodos(){
        List<AcompanhamentoAcai> acompanhamentos = new ArrayList<>();
        String sql = "SELECT ID, NOME, PRECO FROM ACOMPANHAMENTOS_ACAI";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            try(ResultSet resultAcompanhamentos = statement.executeQuery()){
                while(resultAcompanhamentos.next()){
                    acompanhamentos.add(new AcompanhamentoAcai(
                resultAcompanhamentos.getInt("ID"),    
                resultAcompanhamentos.getString("NOME"),
                resultAcompanhamentos.getDouble("PRECO")));
                }
            }
            closeConnection(statement);
        }catch(Exception e){
            System.err.println("Erro ao obter todos os Acompanhamentos");
        }
        return acompanhamentos;
    }
    @Override
    public void incluir(AcompanhamentoAcai acompanhamento){
        String sql = "INSERT INTO ACOMPANHAMENTOS_ACAI(NOME, PRECO) VALUES(?, ?)";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setString(1, acompanhamento.getnome());
            statement.setDouble(2, acompanhamento.getpreco());
            statement.execute();
            closeConnection(statement);
        } catch(Exception e){
            System.err.println("Erro ao inserir o Acompanhamento");
        }    
    }
    @Override
    public void excluir(Integer id){
    String sql = "DELETE FROM ACOMPANAHMENTOS_ACAI WHERE ID= ?";
    try(PreparedStatement statement = getConnection().prepareStatement(sql)){
        statement.setInt(1, id);
        statement.execute();
        closeConnection(statement);
    } catch(Exception e){
        System.err.println("Erro ao excluir acompanhamento");
    }
    }
    @Override
    public void alterar(AcompanhamentoAcai acompanhamento){
        String sql = "UPDATE ACOMPANHAMENTOS_ACAI SET NOME = ?, PRECO = ?" + "WHERE ID = ?";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setString(1, acompanhamento.getnome());
            statement.setDouble(2, acompanhamento.getpreco());
            statement.setInt(3, acompanhamento.getId());
            statement.executeUpdate();
            closeConnection(statement);

        } catch(Exception e){
            System.err.println("Erro ao alterar o Acompanhamento");
        }
    }
}
