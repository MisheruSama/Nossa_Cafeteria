package com.NossaCafeteria.Cardapio.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bebida_gelada")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BebidaGelada extends Produto{
    private String tipo;

}


