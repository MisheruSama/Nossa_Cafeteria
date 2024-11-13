package com.NossaCafeteria.Cardapio.Model;

public class Tapioca {
   private Integer id;
    private String sabor;
    private double preco;
 
    public Tapioca (Integer id, String sabor, double preco) {
      this.id=id;
       this.sabor=sabor;
       this.preco = preco;
    }
 
    public String getsabor() {
       return sabor;
    }
 
    public double getPreco() {
       return preco;
    }
    public void setsabor(String sabor){
      this.sabor=sabor;
    }
    public void setPreco(double preco){
      this.preco=preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
 }
 