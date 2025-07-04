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

import com.NossaCafeteria.Cardapio.Model.Cafe;
import com.NossaCafeteria.Cardapio.Repository.CafeRepository;

@RestController
@RequestMapping("/cafes/api")
public class CafeController {
@Autowired
private CafeRepository cafe;

@GetMapping
public List<Cafe> listarCafes(){
    return cafe.findAll();
}
@PostMapping("/cafes/salvar")
@ResponseStatus(HttpStatus.CREATED)
public String salvarCafe(@RequestBody Cafe cafes){
    cafe.save(cafes);
    return "Cafe salvo com sucesso";
}
@DeleteMapping("/cafes/excluir")
@ResponseStatus(HttpStatus.NOT_FOUND)
public String excluirCafe(@RequestBody Cafe cafes){
    cafe.delete(cafes);
    return "Cafe excluido com sucesso";
}
@PostMapping("/cafes/alterar")
public String editarCafe(@RequestBody Cafe cafes){
   Optional<Cafe> cafeExistente = cafe.findById(cafes.getId());
   if(cafeExistente.isPresent()){
       cafeExistente.get().setNome(cafes.getNome());
       cafeExistente.get().setPreco(cafes.getPreco());
       cafeExistente.get().setDescricao(cafes.getDescricao());
       cafeExistente.get().setTipo(cafes.getTipo());
       cafe.save(cafeExistente.get());
   }
   return "Cafe Alterado com sucesso";
}
}
