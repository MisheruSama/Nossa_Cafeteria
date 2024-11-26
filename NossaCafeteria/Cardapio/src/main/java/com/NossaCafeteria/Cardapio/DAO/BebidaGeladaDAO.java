package com.NossaCafeteria.Cardapio.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.NossaCafeteria.Cardapio.Model.BebidaGelada;

@Repository
public class BebidaGeladaDAO extends GenericDAO<BebidaGelada,Integer>{
    @Override
    public List<BebidaGelada> obterTodos(){
        List<BebidaGelada> Bebidas = new ArrayList<>();
        String sql = "SELECT ID, NOME, PRECO, TIPO, DESCRICAO FROM BEBIDA_GELADA";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            try(ResultSet resultBebidas = statement.executeQuery()){
                while(resultBebidas.next()){
                    Bebidas.add(new BebidaGelada(resultBebidas.getInt("ID"),
                        resultBebidas.getString("NOME"),
                    resultBebidas.getDouble("PRECO"),
                    resultBebidas.getString("TIPO"),
                    resultBebidas.getString("DESCRICAO")));
                }
            }
            closeConnection(statement);
        }catch(Exception e){
            System.err.println("Erro ao obter todas as Bebidas Geladas");
        }
        return Bebidas;
    }
    @Override
    public void incluir(BebidaGelada bebida){
        String sql = "INSERT INTO BEBIDA_GELADA(NOME, PRECO, TIPO, DESCRICAO) VALUES (?, ?, ?, ?)";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setString(1, bebida.getnome());
            statement.setDouble(2, bebida.getpreco());
            statement.setString(3, bebida.getTipo());
            statement.setString(4, bebida.getDescricao());
            statement.execute();
            closeConnection(statement);
        } catch(Exception e){
            System.err.println("Erro ao adcionar uma nova Bebida Gelada.");
        }
    }
    @Override
    public void excluir(Integer id){
        String sql = "DELETE FROM BEBIDA_GELADA WHERE ID = ?";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setInt(1,id);
            statement.executeUpdate();
            closeConnection(statement);
        } catch(Exception e){
            System.err.println("Erro ao excluir a Bebida Gelada");
        }
    }
    @Override
    public void alterar(BebidaGelada bebida){
        String sql = "UPDATE BEBIDA_GELADA SET NOME = ?, PRECO = ?, TIPO = ?, DESCRICAO = ?" + "WHERE ID = ?";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setString(1, bebida.getnome());
            statement.setDouble(2, bebida.getpreco());
            statement.setString(3, bebida.getTipo());
            statement.setString(4, bebida.getDescricao());
            statement.setInt(5, bebida.getId());
            statement.executeUpdate();
            closeConnection(statement);
        } catch(Exception e ){
            System.err.println("Erro ao alterar a Bebida Gelada");
        }
        }
    }