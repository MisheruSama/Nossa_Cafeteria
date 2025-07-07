package com.NossaCafeteria.Cardapio.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sanduiches")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sanduiche extends Produto{
    private String tipo;
}
