package com.NossaCafeteria.Cardapio.Model;



public class Acai{
    private Integer id; 
    private int tamanho;
    private double preco;

    public Acai(){};
    
    public Acai(Integer id, int tamanho, double preco) {
        this.id=id;
        this.tamanho = tamanho;
        this.preco=preco;
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
}