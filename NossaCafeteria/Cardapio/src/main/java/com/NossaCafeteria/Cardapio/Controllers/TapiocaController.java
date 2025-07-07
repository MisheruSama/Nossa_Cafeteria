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

import com.NossaCafeteria.Cardapio.Model.Tapioca;
import com.NossaCafeteria.Cardapio.Repository.TapiocaRepository;

@RestController
@RequestMapping("/tapioca/api")
public class TapiocaController {
@Autowired
private TapiocaRepository tapioca;


@GetMapping
public List<Tapioca> listarTapiocas(){
    return tapioca.findAll();
}
@PostMapping("/salvar")
@ResponseStatus(HttpStatus.CREATED)
public String salvarTapioca(@RequestBody Tapioca tapiocas){
    tapioca.save(tapiocas);
    return "Tapioca salva com sucesso";
}
@DeleteMapping("/excluir")
@ResponseStatus(HttpStatus.NO_CONTENT)
public String excluir(@RequestBody Tapioca tapiocas){
    tapioca.delete(tapiocas);
    return "Tapioca excluída com sucesso";
}
@PostMapping("/alterar")
public String editarTapioca(@RequestBody Tapioca tapiocas){
    Optional<Tapioca> tapiocaExistente = tapioca.findById(tapiocas.getId());
    if(tapiocaExistente.isPresent()){
        tapiocaExistente.get().setNome(tapiocas.getNome());
        tapiocaExistente.get().setPreco(tapiocas.getPreco());
        tapiocaExistente.get().setDescricao(tapiocas.getDescricao());
        tapiocaExistente.get().setTipo(tapiocas.getTipo());
        tapioca.save(tapiocaExistente.get());
        return "Tapioca alterada com sucesso";
    } else {
        return "Tapioca não encontrada";
    }
}
}
