package com.NossaCafeteria.Cardapio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NossaCafeteria.Cardapio.Model.Cafe;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Integer>{

}
