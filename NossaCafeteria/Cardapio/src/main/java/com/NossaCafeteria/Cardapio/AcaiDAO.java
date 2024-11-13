package com.NossaCafeteria.Cardapio;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.NossaCafeteria.Cardapio.Model.Acai;

@Repository
public class AcaiDAO extends GenericDAO<Acai,Integer>{
    @Override
    public void incluir(Acai acai){
    String sql = "INSERT INTO ACAI(TAMANHO, PRECO) VALUES(?, ?)";
    try(PreparedStatement statement = getConnection().prepareStatement(sql)){
        statement.setInt(1, acai.gettamanho());
        statement.setDouble(2, acai.getpreco());
        statement.execute();
        closeConnection(statement);
    } catch (Exception e){
        System.err.println("Erro ao inserir o Acai no banco de dados");
    }
    }
    @Override
    public void excluir(Integer id){
        String sql = "DELETE FROM ACAI WHERE ID = ?";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setInt(1, id);
            statement.executeUpdate();
            closeConnection(statement);
        } catch(Exception e){
            System.err.println("Erro ao exluir um Acai");
        }
    }
    @Override
    public void alterar(Acai acai){
    String sql = "UPDATE ACAI SET TAMANHO = ?, PRECO = ?" + "WHERE ID = ?";
    try(PreparedStatement statement = getConnection().prepareStatement(sql)){
        statement.setInt(1, acai.gettamanho());
        statement.setDouble(2, acai.getpreco());
        statement.setInt(3, acai.getId());
        statement.executeUpdate();
        closeConnection(statement);
    } catch(Exception e ){
        System.err.println("Erro ao alterar o Açai");
    }
    }
    @Override
    public List<Acai> obterTodos(){
        List<Acai> Acais = new ArrayList<>();
        String sql = "SELECT ID, TAMANHO, PRECO FROM ACAI";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            try(ResultSet resultAcai = statement.executeQuery()){
            while(resultAcai.next()){
                Acais.add(new Acai(resultAcai.getInt("ID"),
                resultAcai.getInt("TAMANHO"),
                resultAcai.getDouble("PRECO")));
            }
            }
            closeConnection(statement);
        }catch(Exception e){
        }    
        return Acais;
    }
}
