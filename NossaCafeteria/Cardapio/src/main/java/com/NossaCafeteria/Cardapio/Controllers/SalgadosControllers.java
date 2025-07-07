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

import com.NossaCafeteria.Cardapio.Model.Salgados;
import com.NossaCafeteria.Cardapio.Repository.SalgadosRepository;

@RestController
@RequestMapping("/salgados/api")
public class SalgadosControllers {

@Autowired
private SalgadosRepository salgados;


@GetMapping
public List<Salgados> listarSalgados(){
    return salgados.findAll();
}
@PostMapping("/salvar")
@ResponseStatus(HttpStatus.CREATED)
public String salvarSalgado(@RequestBody Salgados salgado){
    salgados.save(salgado);
    return "Salgado salvo com sucesso";
}
@DeleteMapping("/excluir")
@ResponseStatus(HttpStatus.NO_CONTENT)
public String excluirSalgado(@RequestBody Salgados salgado){
    salgados.delete(salgado);
    return "Salgado excluído com sucesso";
}
@PostMapping("/alterar")
public String editarSalgado(@RequestBody Salgados salgado){
    Optional<Salgados> salgadoExistente = salgados.findById(salgado.getId());
    if(salgadoExistente.isPresent()){
        salgadoExistente.get().setNome(salgado.getNome());
        salgadoExistente.get().setPreco(salgado.getPreco());
        salgadoExistente.get().setDescricao(salgado.getDescricao());
        salgadoExistente.get().setTipo(salgado.getTipo());
        salgados.save(salgadoExistente.get());
        return "Salgado Alterado com sucesso";
    } else {
        return "Salgado não encontrado";
    }
}
}