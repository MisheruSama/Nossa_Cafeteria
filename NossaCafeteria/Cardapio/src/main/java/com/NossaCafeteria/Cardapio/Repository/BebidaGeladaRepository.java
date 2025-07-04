package com.NossaCafeteria.Cardapio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NossaCafeteria.Cardapio.Model.BebidaGelada;

@Repository
public interface BebidaGeladaRepository extends JpaRepository<BebidaGelada, Integer>{

}
