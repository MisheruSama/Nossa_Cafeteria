package com.NossaCafeteria.Cardapio.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "acai")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Acai extends Produto{
    private String tipo;
    
}