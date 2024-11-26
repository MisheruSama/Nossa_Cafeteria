package com.NossaCafeteria.Cardapio.Model;


public class BebidaGelada extends Produto{
    private String tipo;
    private String descricao;

    public BebidaGelada(Integer id, String nome, Double preco, String tipo, String descricao) {
        super(id, nome, preco);
        this.tipo = tipo;
        this.descricao=descricao;
    }

    public String getTipo() {
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


