package com.NossaCafeteria.Cardapio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BebidaGeladaDAO extends GenericDAO<BebidaGelada,Integer>{
    @Override
    public List<BebidaGelada> obterTodos(){
        List<BebidaGelada> Bebidas = new ArrayList<>();
        String sql = "SELECT ID, NOME, PRECO, TIPO FROM BEBIDA_GELADA";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            try(ResultSet resultBebidas = statement.executeQuery()){
                while(resultBebidas.next()){
                    Bebidas.add(new BebidaGelada(resultBebidas.getInt("ID"),
                        resultBebidas.getString("NOME"),
                    resultBebidas.getDouble("PRECO"),
                    resultBebidas.getString("TIPO")));
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
        String sql = "INSERT INTO BEBIDA_GELADA(NOME, PRECO, TIPO) VALUES (?, ?, ?)";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setString(1, bebida.getnome());
            statement.setDouble(2, bebida.getpreco());
            statement.setString(3, bebida.getTipo());
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
        String sql = "UPDATE BEBIDA_GELADA SET NOME = ?, PRECO = ?, TIPO = ?" + "WHERE ID = ?";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setString(1, bebida.getnome());
            statement.setDouble(2, bebida.getpreco());
            statement.setString(3, bebida.getTipo());
            statement.setInt(4, bebida.getId());
            statement.executeUpdate();
            closeConnection(statement);
        } catch(Exception e ){
            System.err.println("Erro ao alterar a Bebida Gelada");
        }
        }
    }