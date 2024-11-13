package com.NossaCafeteria.Cardapio.Model;

public class Cafe extends Produto{
    private String tipo;
    
    public Cafe(Integer id, String nome, double preco, String tipo) {
        super(id, nome, preco);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    public void SetTipo(String tipo){
        this.tipo=tipo;
    }

    
}



