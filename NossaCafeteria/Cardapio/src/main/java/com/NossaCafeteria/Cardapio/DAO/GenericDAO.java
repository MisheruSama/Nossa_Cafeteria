package com.NossaCafeteria.Cardapio.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public abstract class GenericDAO<E,K>{
    protected Connection getConnection() throws Exception{
      Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/cardapio", "root", "Misheru010@");
    }
    protected void closeConnection(PreparedStatement statement)throws Exception{
       statement.close();
    }
  public abstract void incluir(E entidade);
  public abstract void excluir(K chave);
  public abstract void alterar(E entidade);
  public abstract List<E> obterTodos();
  }



