package com.NossaCafeteria.Cardapio.Model;

public class Tapioca {
   private Integer id;
    private String sabor;
    private Double preco;
 
    public Tapioca (Integer id, String sabor, Double preco) {
      this.id=id;
       this.sabor=sabor;
       this.preco = preco;
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
 }
 