package com.NossaCafeteria.Cardapio.Model;

public class Sanduiche extends Produto{
    private String tipo;

    public Sanduiche(){};

    public Sanduiche(Integer id, String nome, Double preco, String tipo){
        super(id, nome, preco);
        this.tipo=tipo;
    }
    public String gettipo(){
        return tipo;
    }
    public void settipo(String tipo){
        this.tipo=tipo;
    }
    
}
