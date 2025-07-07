package com.NossaCafeteria.Cardapio.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.NossaCafeteria.Cardapio.Model.Doces;
import com.NossaCafeteria.Cardapio.Repository.DocesRepository;

@RestController
@RequestMapping("/doces/api")
public class DocesControllers {
@Autowired
private DocesRepository candy;


@GetMapping
public List<Doces> listarDoces(){
return candy.findAll();
}
@PostMapping("/salvar")
@ResponseStatus(HttpStatus.CREATED)
public String salvarDoces(@RequestBody Doces doce){
    candy.save(doce);
    return "Doce salvo com sucesso";
}
@DeleteMapping("/excluir")
@ResponseStatus(HttpStatus.NO_CONTENT)
public String excluir(@RequestBody Doces doce){
   candy.delete(doce);
   return "Doce excluido com sucesso";
}
@PostMapping("/alterar")
public String editarDoces(@RequestBody Doces doce){
    Optional<Doces> doceExistente = candy.findById(doce.getId());
    if(doceExistente.isPresent()){  
        doceExistente.get().setNome(doce.getNome());
        doceExistente.get().setPreco(doce.getPreco());
        doceExistente.get().setDescricao(doce.getDescricao());
        candy.save(doceExistente.get());
        return "Doce Alterado com sucesso";
    } else {
        return "Doce não encontrado";
    }
    
}
}
