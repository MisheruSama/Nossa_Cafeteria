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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.NossaCafeteria.Cardapio.Model.Sanduiche;
import com.NossaCafeteria.Cardapio.Repository.SanduicheRepository;

@RestController
@RequestMapping("/sanduiches/api")
public class SanduicheController {
@Autowired
private SanduicheRepository sanduiche;


@GetMapping
@ResponseBody
public List<Sanduiche> listarSanduiches(){
    return sanduiche.findAll();
}
@PostMapping("/salvar")
@ResponseStatus(HttpStatus.CREATED)
public String salvar(@RequestBody Sanduiche sanduiches){
    sanduiche.save(sanduiches);
    return "Sanduiche salvo com sucesso.";
}
@DeleteMapping("/excluir")
@ResponseStatus(HttpStatus.NO_CONTENT)
public String excluir(@RequestBody Sanduiche sanduiches){
    sanduiche.delete(sanduiches);
    return "Sanduiche excluído com sucesso.";

}
@PostMapping("/alterar")
public String editar(@RequestBody Sanduiche sanduiches){
    Optional<Sanduiche> sanduicheExistente = sanduiche.findById(sanduiches.getId());
    if(sanduicheExistente.isPresent()){
        sanduicheExistente.get().setNome(sanduiches.getNome());
        sanduicheExistente.get().setPreco(sanduiches.getPreco());
        sanduicheExistente.get().setDescricao(sanduiches.getDescricao());
        sanduicheExistente.get().setTipo(sanduiches.getTipo());
        sanduiche.save(sanduicheExistente.get());
        return "Sanduiche alterado com sucesso.";
    } else {
        return "Sanduiche não encontrado.";
    }
}
}
