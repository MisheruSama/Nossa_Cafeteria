package com.NossaCafeteria.Cardapio.Model;

public class Cafe extends Produto{
    private String tipo;
    
    public Cafe(Integer id, String nome, Double preco, String tipo, String descricao) {
        super(id, nome, preco, descricao);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    public void SetTipo(String tipo){
        this.tipo=tipo;
    }
    
}



