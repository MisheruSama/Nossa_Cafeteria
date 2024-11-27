package com.NossaCafeteria.Cardapio.Model;


public class BebidaGelada extends Produto{
    private String tipo;

    public BebidaGelada(Integer id, String nome, Double preco, String tipo, String descricao) {
        super(id, nome, preco, descricao);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    public void settipo(String tipo){
        this.tipo=tipo;
    }

}


