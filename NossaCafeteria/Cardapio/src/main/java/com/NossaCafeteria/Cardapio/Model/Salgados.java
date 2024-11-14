package com.NossaCafeteria.Cardapio.Model;

public class Salgados extends Produto {
    
    //atributos
    String tipo;

    public Salgados(Integer id, String nome, Double preco, String tipo){
        super(id, nome, preco);
        this.tipo=tipo;
    }

    //getterSetters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
