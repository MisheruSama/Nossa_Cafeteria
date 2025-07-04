package com.NossaCafeteria.Cardapio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NossaCafeteria.Cardapio.Model.Doces;

@Repository
public interface DocesRepository extends JpaRepository<Doces, Integer>{

}
