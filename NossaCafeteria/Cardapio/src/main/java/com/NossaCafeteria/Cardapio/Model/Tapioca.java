package com.NossaCafeteria.Cardapio.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tapioca")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tapioca extends Produto{
    private String tipo;
 }
 