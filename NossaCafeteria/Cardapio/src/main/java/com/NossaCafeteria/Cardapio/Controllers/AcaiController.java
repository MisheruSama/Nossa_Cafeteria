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

import com.NossaCafeteria.Cardapio.Model.Acai;
import com.NossaCafeteria.Cardapio.Repository.AcaiRepository;

@RestController
@RequestMapping("/acai/api")
public class AcaiController {

@Autowired
private AcaiRepository acai;

@GetMapping
public List<Acai> listar(){
    return acai.findAll();
}

@PostMapping("/acai/salvar")
@ResponseStatus(HttpStatus.CREATED)
public void salvarAcai(@RequestBody Acai salvarAcai){
   acai.save(salvarAcai);
}
@DeleteMapping("/acai/excluir")
@ResponseStatus(HttpStatus.NOT_FOUND)
public void exluirAcai(@RequestBody Acai excluirAcai){
   acai.delete(excluirAcai);
}
@PostMapping("/acai/alterar")
public String editarAcai(@RequestBody Acai editAcai){
   Optional<Acai> acaiExistente = acai.findById(editAcai.getId());
   if(acaiExistente.isPresent()){
    acaiExistente.get().setNome(editAcai.getNome());
    acaiExistente.get().setPreco(editAcai.getPreco());
    acaiExistente.get().setDescricao(editAcai.getDescricao());
    acaiExistente.get().setTipo(editAcai.getTipo());
   acai.save(acaiExistente.get());
   }
   return "Funcionario Alterado com sucesso";
}
}
