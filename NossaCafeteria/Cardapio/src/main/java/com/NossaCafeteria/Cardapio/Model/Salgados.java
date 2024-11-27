package com.NossaCafeteria.Cardapio.Model;

public class Salgados extends Produto {
    
    //atributos
    private String tipo;

    public Salgados(Integer id, String nome, Double preco, String tipo, String descricao){
        super(id, nome, preco, descricao);
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
