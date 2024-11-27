package com.NossaCafeteria.Cardapio.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.NossaCafeteria.Cardapio.Model.Doces;

@Repository
public class DocesDAO extends GenericDAO<Doces,Integer>{
    @Override
    public List<Doces> obterTodos(){
        List<Doces> Doces = new ArrayList<>();
        String sql = "SELECT ID, NOME, PRECO, DESCRICAO FROM DOCES";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
        try(ResultSet resultDoces = statement.executeQuery()){
            while(resultDoces.next()){
                Doces.add(new Doces(resultDoces.getInt("ID"),
                    resultDoces.getString("NOME"),
                resultDoces.getDouble("PRECO"),
                resultDoces.getString("DESCRICAO")));
            }
        }
        closeConnection(statement);
        } catch (Exception e) {
            System.err.println("Erro ao obter todos os Doces");
        }
        return Doces;
    }
    @Override
    public void incluir(Doces doces){
    String sql = "INSERT INTO DOCES(NOME, PRECO, DESCRICAO) VALUES(?, ?, ?)";
    try(PreparedStatement statement = getConnection().prepareStatement(sql)){
        statement.setString(1, doces.getnome());
        statement.setDouble(2, doces.getpreco());
        statement.setString(3, doces.getDescricao());
        statement.execute();
        closeConnection(statement);
    } catch (Exception e){
        System.err.println("Erro ao inserir o Doce no banco de dados");
    }
    }
    @Override
    public void excluir(Integer id){
        String sql = "DELETE FROM DOCES WHERE ID = ?";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setInt(1, id);
            statement.executeUpdate();
            closeConnection(statement);
        } catch(Exception e){
            System.err.println("Erro ao exluir um Doce");
        }
    }
    @Override
    public void alterar(Doces doces){
    String sql = "UPDATE DOCES SET NOME = ?, PRECO = ?, DESCRICAO = ?" + "WHERE ID = ?";
    try(PreparedStatement statement = getConnection().prepareStatement(sql)){
        statement.setString(1, doces.getnome());
        statement.setDouble(2, doces.getpreco());
        statement.setString(3, doces.getDescricao());
        statement.setInt(4, doces.getId());
        statement.executeUpdate();
        closeConnection(statement);
    } catch(Exception e ){
        System.err.println("Erro ao alterar o Doce");
    }
    }
}
