package com.NossaCafeteria.Cardapio.Model;



public class Acai{
    private Integer id; 
    private int tamanho;
    private double preco;
    private String tipo;
    private String descricao;

    public Acai(){};
    
    public Acai(Integer id, int tamanho, double preco, String tipo, String descricao) {
        this.id=id;
        this.tamanho = tamanho;
        this.preco=preco;
        this.tipo=tipo;
        this.descricao=descricao;
    }

    public int gettamanho() {
        return tamanho;
    }

    public void settamanho(int tamanho) {
        this.tamanho=tamanho;
    }
    
    public double getpreco(){
        return preco;
    }
    public void setpreco(double preco){
        this.preco=preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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