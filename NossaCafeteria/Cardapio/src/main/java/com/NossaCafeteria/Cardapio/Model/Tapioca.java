package com.NossaCafeteria.Cardapio.Model;

public class Tapioca extends Produto{
    private String tipo;
    private String descricao;
    
    public Tapioca (Integer id, String nome, double preco, String tipo, String descricao) {
        super(id, nome, preco);
       this.tipo=tipo;
       this.descricao=descricao;
    }

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
 