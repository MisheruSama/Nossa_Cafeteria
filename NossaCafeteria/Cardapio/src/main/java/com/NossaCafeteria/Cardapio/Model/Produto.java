package com.NossaCafeteria.Cardapio.Model;



public abstract class Produto {
    private Integer id;
    private String nome;
    private Double preco;
    private String descricao;

    public Produto(){}

    public Produto(Integer id, String nome, Double preco, String descricao){
        this.id=id;
        this.nome=nome;
        this.preco=preco;
        this.descricao=descricao;
    }
    public String getnome(){
        return nome;
    }
    public Double getpreco(){
        return preco;
    }
    public void setnome(String nome){
        this.nome=nome;
    }
    public void setpreco(Double preco){
        this.preco=preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
