package com.NossaCafeteria.Cardapio.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.NossaCafeteria.Cardapio.Model.Tapioca;

@Repository
public class TapiocaDAO extends GenericDAO<Tapioca,Integer>{
    @Override
    public List<Tapioca> obterTodos(){
        List<Tapioca> tapiocas = new ArrayList<>();
        String sql = "SELECT ID, SABOR, PRECO, TIPO, DESCRICAO FROM TAPIOCA";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
        try(ResultSet resultTapioca = statement.executeQuery()){
            while(resultTapioca.next()){
                tapiocas.add(new Tapioca(resultTapioca.getInt("ID"),
                resultTapioca.getString("SABOR"),
                resultTapioca.getDouble("PRECO"),
                resultTapioca.getString("TIPO"),
                resultTapioca.getString("DESCRICAO")));
            }
        }
        closeConnection(statement);
        }catch(Exception e){
            System.err.println("Erro ao obter todas as Tapiocas");
        }
        return tapiocas;
        }
        @Override
        public void incluir(Tapioca tapioca){
        String sql = "INSERT INTO TAPIOCA(SABOR, PRECO, TIPO, DESCRICAO) VALUES(?, ?, ?, ?)";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setString(1, tapioca.getnome());
            statement.setDouble(2, tapioca.getpreco());
            statement.setString(3, tapioca.getTipo());
            statement.setString(4, tapioca.getDescricao());
            statement.execute();
            closeConnection(statement);
        } catch (Exception e){
            System.err.println("Erro ao inserir a Tapioca no banco de dados");
        }
        }
        @Override
        public void excluir(Integer id){
            String sql = "DELETE FROM TAPIOCA WHERE ID = ?";
            try(PreparedStatement statement = getConnection().prepareStatement(sql)){
                statement.setInt(1, id);
                statement.executeUpdate();
                closeConnection(statement);
            } catch(Exception e){
                System.err.println("Erro ao exluir uma Tapioca");
            }
        }
        @Override
        public void alterar(Tapioca tapioca){
        String sql = "UPDATE TAPIOCA SET SABOR = ?, PRECO = ?, TIPO = ?, DESCRICAO = ?" + "WHERE ID = ?";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setString(1, tapioca.getnome());
            statement.setDouble(2, tapioca.getpreco());
            statement.setString(3, tapioca.getTipo());
            statement.setString(4, tapioca.getDescricao());
            statement.setInt(5, tapioca.getId());
            statement.executeUpdate();
            closeConnection(statement);
        } catch(Exception e ){
            System.err.println("Erro ao alterar a Tapioca");
        }
        }
}
