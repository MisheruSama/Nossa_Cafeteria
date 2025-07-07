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

import com.NossaCafeteria.Cardapio.Model.BebidaGelada;
import com.NossaCafeteria.Cardapio.Repository.BebidaGeladaRepository;


@RestController
@RequestMapping("/bebidas/api")
public class BebidaGeladaController {
@Autowired
private BebidaGeladaRepository bebida;


@GetMapping
public List<BebidaGelada> listarBebidasAPI(){
    return bebida.findAll();
}
@PostMapping("/salvar")
@ResponseStatus(HttpStatus.CREATED)
public void salvarBebida(@RequestBody BebidaGelada bebidasGelada){
    bebida.save(bebidasGelada);
}
@DeleteMapping("/excluir")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void excluirBebida(@RequestBody BebidaGelada bebidasBebidaGelada){
    bebida.delete(bebidasBebidaGelada);
}
@PostMapping("/alterar")
public String editarBebida(@RequestBody BebidaGelada bebidasGelada){
    Optional<BebidaGelada> bebidaExistente = bebida.findById(bebidasGelada.getId());
    if(bebidaExistente.isPresent()){
        bebidaExistente.get().setNome(bebidasGelada.getNome());
        bebidaExistente.get().setPreco(bebidasGelada.getPreco());
        bebidaExistente.get().setDescricao(bebidasGelada.getDescricao());
        bebidaExistente.get().setTipo(bebidasGelada.getTipo());
        bebida.save(bebidaExistente.get());
    }
    return "Bebida Alterada com sucesso";
}
}
