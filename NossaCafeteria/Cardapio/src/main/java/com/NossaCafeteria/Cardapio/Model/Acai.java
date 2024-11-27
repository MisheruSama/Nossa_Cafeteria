package com.NossaCafeteria.Cardapio.Model;



public class Acai extends Produto{
    private String tipo;
    

    public Acai(){};
    
    public Acai(Integer id, String nome, double preco, String tipo, String descricao) {
        super(id, nome, preco, descricao);
        this.tipo=tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}