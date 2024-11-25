package com.NossaCafeteria.Cardapio.Model;

public class Salgados extends Produto {
    
    //atributos
    private String tipo;
    private String descricao;

    public Salgados(Integer id, String nome, Double preco, String tipo, String descricao){
        super(id, nome, preco);
        this.tipo=tipo;
        this.descricao=descricao;
    }

    //getterSetters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
