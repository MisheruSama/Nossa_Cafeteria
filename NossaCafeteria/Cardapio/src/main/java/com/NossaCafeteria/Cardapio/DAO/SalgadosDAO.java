package com.NossaCafeteria.Cardapio.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.NossaCafeteria.Cardapio.Model.Salgados;

@Repository
public class SalgadosDAO extends GenericDAO<Salgados,Integer>{
    @Override
   public List<Salgados> obterTodos(){
    List<Salgados> Salgado = new ArrayList<>();
    String sql = "SELECT ID, NOME, PRECO, TIPO, DESCRICAO FROM SALGADOS";
    try(PreparedStatement statement = getConnection().prepareStatement(sql)){
    try(ResultSet resultSalgado = statement.executeQuery()){
        while(resultSalgado.next()){
            Salgado.add(new Salgados(resultSalgado.getInt("ID"),
                resultSalgado.getString("NOME"),
            resultSalgado.getDouble("PRECO"),
            resultSalgado.getString("TIPO"),
            resultSalgado.getString("DESCRICAO")));
        }
    }
    closeConnection(statement);
    }catch(Exception e){
        System.err.println("Erro ao obter todos os Salgados");
    } 
    return Salgado;
   }
   @Override
   public void incluir(Salgados salgados){
   String sql = "INSERT INTO SALGADOS(NOME, PRECO, TIPO, DESCRICAO) VALUES(?, ?, ?, ?)";
   try(PreparedStatement statement = getConnection().prepareStatement(sql)){
       statement.setString(1, salgados.getnome());
       statement.setDouble(2, salgados.getpreco());
       statement.setString(3, salgados.getTipo());
       statement.setString(4,salgados.getDescricao());
       statement.executeUpdate();
       closeConnection(statement);
   } catch (Exception e){
       System.err.println("Erro ao inserir o Salgado no banco de dados");
   }
   }
   @Override
   public void excluir(Integer id){
       String sql = "DELETE FROM SALGADOS WHERE ID = ?";
       try(PreparedStatement statement = getConnection().prepareStatement(sql)){
           statement.setInt(1, id);
           statement.executeUpdate();
           closeConnection(statement);
       } catch(Exception e){
           System.err.println("Erro ao exluir um Salgado");
       }
   }
   @Override
   public void alterar(Salgados salgados){
   String sql = "UPDATE SALGADOS SET NOME = ?, PRECO = ?, TIPO = ?, DESCRICAO= ?" + "WHERE ID = ?";
   try(PreparedStatement statement = getConnection().prepareStatement(sql)){
       statement.setString(1, salgados.getnome());
       statement.setDouble(2, salgados.getpreco());
       statement.setString(3, salgados.getTipo());
       statement.setString(4,salgados.getDescricao());
       statement.setInt(5, salgados.getId());
       statement.executeUpdate();
       closeConnection(statement);
   } catch(Exception e ){
       System.err.println("Erro ao alterar o Salgado");
   }
   }
}
