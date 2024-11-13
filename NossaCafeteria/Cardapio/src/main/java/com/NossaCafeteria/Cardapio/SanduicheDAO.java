package com.NossaCafeteria.Cardapio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SanduicheDAO extends GenericDAO<Sanduiche,Integer>{
@Override
 public List<Sanduiche> obterTodos(){
    List<Sanduiche> sanduiches = new ArrayList<>();
    String sql = "SELECT ID, NOME, PRECO, DESCRICAO FROM SANDUICHES";
    try(PreparedStatement statement = getConnection().prepareStatement(sql)){
    try(ResultSet resultSanduiche = statement.executeQuery()){
        while(resultSanduiche.next()){
            sanduiches.add(new Sanduiche(resultSanduiche.getInt("ID"),
                resultSanduiche.getString("NOME"),
            resultSanduiche.getDouble("PRECO"),
            resultSanduiche.getString("DESCRICAO")));
        }
    }
    closeConnection(statement);
    }catch(Exception e){
        System.err.println("Erro ao obter todos os Sanduiches");
    }
    return sanduiches;
 }
 @Override
 public void incluir(Sanduiche sanduiche){
 String sql = "INSERT INTO SANDUICHES(NOME, PRECO, DESCRICAO) VALUES(?, ?, ?)";
 try(PreparedStatement statement = getConnection().prepareStatement(sql)){
     statement.setString(1, sanduiche.getnome());
     statement.setDouble(2, sanduiche.getpreco());
     statement.setString(3, sanduiche.getdescricao());
     statement.execute();
     closeConnection(statement);
 } catch (Exception e){
     System.err.println("Erro ao inserir o Sanduiche no banco de dados");
 }
 }
 @Override
 public void excluir(Integer id){
     String sql = "DELETE FROM SANDUICHES WHERE ID = ?";
     try(PreparedStatement statement = getConnection().prepareStatement(sql)){
         statement.setInt(1, id);
         statement.executeUpdate();
         closeConnection(statement);
     } catch(Exception e){
         System.err.println("Erro ao exluir um Sanduiche");
     }
 }
 @Override
 public void alterar(Sanduiche sanduiche){
 String sql = "UPDATE SANDUICHES SET NOME = ?, PRECO = ?, DESCRICAO = ?" + "WHERE ID = ?";
 try(PreparedStatement statement = getConnection().prepareStatement(sql)){
     statement.setString(1, sanduiche.getnome());
     statement.setDouble(2, sanduiche.getpreco());
     statement.setString(3,sanduiche.getdescricao());
     statement.setInt(4, sanduiche.getId());
     statement.executeUpdate();
     closeConnection(statement);
 } catch(Exception e ){
     System.err.println("Erro ao alterar o Sanduiche");
 }
 }
}