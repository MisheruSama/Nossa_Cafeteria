package com.NossaCafeteria.Cardapio.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.NossaCafeteria.Cardapio.Model.Cafe;

@Repository
public  class CafeDAO extends GenericDAO<Cafe,Integer>{
    @Override
    public List<Cafe> obterTodos(){
        String sql = "SELECT ID, NOME, PRECO, TIPO FROM CAFE";
        List<Cafe> Cafes = new ArrayList<>();
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
        try(ResultSet resultCafe = statement.executeQuery()){
            while(resultCafe.next()){
                Cafes.add(new Cafe(resultCafe.getInt("ID"),
                    resultCafe.getString("NOME"),
                resultCafe.getDouble("PRECO"),
                resultCafe.getString("TIPO")));
            }
        }
        closeConnection(statement);
        }catch(Exception e){
            System.err.println("Erro ao obter todos os Cafés");
        }
        return Cafes;
    }
    @Override
    public void incluir(Cafe cafe){
    String sql = "INSERT INTO CAFE(NOME, PRECO, TIPO) VALUES(?, ?, ?)";
    try(PreparedStatement statement = getConnection().prepareStatement(sql)){
        statement.setString(1, cafe.getnome());
        statement.setDouble(2, cafe.getpreco());
        statement.setString(3, cafe.getTipo());
        statement.execute();
        closeConnection(statement);
    } catch (Exception e){
        System.err.println("Erro ao inserir o Café");
    }
    }
    @Override
    public void excluir(Integer id){
        String sql = "DELETE FROM CAFE WHERE ID = ?";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setInt(1, id);
            statement.executeUpdate();
            closeConnection(statement);
        } catch(Exception e){
            System.err.println("Erro ao exluir um Café");
        }
    }
    @Override
    public void alterar(Cafe cafe){
    String sql = "UPDATE CAFE SET NOME = ?, PRECO = ?, TIPO = ?" + "WHERE ID = ?";
    try(PreparedStatement statement = getConnection().prepareStatement(sql)){
        statement.setString(1, cafe.getnome());
        statement.setDouble(2, cafe.getpreco());
        statement.setString(3, cafe.getTipo());
        statement.setInt(4, cafe.getId());
        statement.executeUpdate();
        closeConnection(statement);
    } catch(Exception e ){
        System.err.println("Erro ao alterar o Café");
    }
    }
}
