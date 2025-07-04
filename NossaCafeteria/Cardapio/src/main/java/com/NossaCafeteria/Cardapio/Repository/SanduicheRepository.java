package com.NossaCafeteria.Cardapio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NossaCafeteria.Cardapio.Model.Sanduiche;

@Repository
public interface SanduicheRepository extends JpaRepository<Sanduiche, Integer>{

}
