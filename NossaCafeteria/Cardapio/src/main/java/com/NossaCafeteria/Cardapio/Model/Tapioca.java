package com.NossaCafeteria.Cardapio.Model;

public class Tapioca {
   private Integer id;
    private String sabor;
    private Double preco;
    private String tipo;
    private String descricao;
    
    public Tapioca (Integer id, String sabor, Double preco, String tipo, String descricao) {
      this.id=id;
       this.sabor=sabor;
       this.preco = preco;
       this.tipo=tipo;
       this.descricao=descricao;
    }
 
    public String getsabor() {
       return sabor;
    }
 
    public Double getPreco() {
       return preco;
    }
    public void setsabor(String sabor){
      this.sabor=sabor;
    }
    public void setPreco(Double preco){
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
 