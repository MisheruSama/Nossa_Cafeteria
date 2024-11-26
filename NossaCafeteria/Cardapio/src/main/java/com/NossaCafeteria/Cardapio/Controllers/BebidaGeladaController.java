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

import com.NossaCafeteria.Cardapio.DAO.BebidaGeladaDAO;
import com.NossaCafeteria.Cardapio.Model.BebidaGelada;

@Controller
public class BebidaGeladaController {
@Autowired
private BebidaGeladaDAO bebida;

@GetMapping("/bebidas")
public String indexBebida(){
    return "bebidas.html";
}
@GetMapping("/bebidas/api")
@ResponseBody
public List<BebidaGelada> listarBebidasAPI(){
    return bebida.obterTodos();
}
@PostMapping("/bebidas/salvar")
public String salvarBebida(@RequestBody BebidaGelada bebidasGelada){
    bebida.incluir(bebidasGelada);
    return "redirect:/bebidas.html";
}
@DeleteMapping("/bebidas/excluir/{id}")
public ResponseEntity<String> excluirBebida(@PathVariable Integer id){
    try{
    bebida.excluir(id);
    return ResponseEntity.ok("Item excluido com sucesso");
    } catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir item");
    }
}
@PostMapping("/bebidas/alterar")
public String editarBebida(@RequestBody BebidaGelada bebidasGelada){
    bebida.alterar(bebidasGelada);
    return "redirect:/bebidas.html";
}
}
