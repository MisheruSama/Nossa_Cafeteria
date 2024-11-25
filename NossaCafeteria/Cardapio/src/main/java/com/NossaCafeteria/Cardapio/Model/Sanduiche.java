package com.NossaCafeteria.Cardapio.Model;

public class Sanduiche extends Produto{
    private String tipo;
    private String descricao;

    public Sanduiche(){};

    public Sanduiche(Integer id, String nome, Double preco, String tipo, String descricao){
        super(id, nome, preco);
        this.tipo=tipo;
        this.descricao=descricao;
    }
    public String gettipo(){
        return tipo;
    }
    public void settipo(String tipo){
        this.tipo=tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
