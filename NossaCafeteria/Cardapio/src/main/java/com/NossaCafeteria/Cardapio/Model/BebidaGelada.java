package com.NossaCafeteria.Cardapio.Model;


public class BebidaGelada extends Produto{
    private String tipo;

    public BebidaGelada(Integer id, String nome, Double preco, String tipo) {
        super(id, nome, preco);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    public void settipo(String tipo){
        this.tipo=tipo;
    }


}


