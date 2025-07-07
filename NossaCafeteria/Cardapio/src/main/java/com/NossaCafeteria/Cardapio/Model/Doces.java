package com.NossaCafeteria.Cardapio.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "doces")
@Getter
@Setter
public class Doces extends Produto{
}
