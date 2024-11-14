package com.NossaCafeteria.Cardapio.Model;

public class Sanduiche extends Produto{
    private String descricao;

    public Sanduiche(){};

    public Sanduiche(Integer id, String nome, Double preco, String descricao){
        super(id, nome, preco);
        this.descricao=descricao;
    }
    public String getdescricao(){
        return descricao;
    }
    public void setdescricao(String descricao){
        this.descricao=descricao;
    }
    
}
