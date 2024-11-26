package com.NossaCafeteria.Cardapio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.NossaCafeteria.Cardapio.DAO.CafeDAO;
import com.NossaCafeteria.Cardapio.Model.Cafe;

@Controller
public class CafeController {
@Autowired
private CafeDAO cafe;

@GetMapping("/cafes")
public String indexCafe(){
    return "bebidas.html";
}
@GetMapping("/cafes/api")
@ResponseBody
public List<Cafe> listarCafes(){
    return cafe.obterTodos();
}
@PostMapping("/cafes/salvar")
public String salvarCafe(@RequestBody Cafe cafes){
    cafe.incluir(cafes);
    return "redirect:/bebidas.html";
}
@DeleteMapping("/cafes/excluir/{id}")
public ResponseEntity<String> excluirCafe(@PathVariable Integer id){
    try{
    cafe.excluir(id);
    return ResponseEntity.ok("Item excluido com sucesso");
    } catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir o item");
    }
}
@PostMapping("/cafes/alterar")
public String editarCafe(@RequestBody Cafe cafes){
    cafe.alterar(cafes);
    return "redirect:/bebidas.html";
}
}
