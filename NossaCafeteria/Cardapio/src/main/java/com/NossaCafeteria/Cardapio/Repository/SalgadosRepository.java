package com.NossaCafeteria.Cardapio.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NossaCafeteria.Cardapio.Model.Salgados;

@Repository
public interface SalgadosRepository extends JpaRepository<Salgados, Integer>{

}
