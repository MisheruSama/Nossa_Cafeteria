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

import com.NossaCafeteria.Cardapio.DAO.DocesDAO;
import com.NossaCafeteria.Cardapio.Model.Doces;

@Controller
public class DocesControllers {
@Autowired
private DocesDAO candy;

@GetMapping("/doces.html")
public String indexDoces(){
    return "doces.html";
}
@GetMapping("/doces/api")
@ResponseBody
public List<Doces> listarDoces(){
return candy.obterTodos();
}
@PostMapping("/doces/salvar")
public String salvarDoces(@RequestBody Doces doce){
    candy.incluir(doce);
    return "redirect:/doces.html";
}
@DeleteMapping("/doces/excluir/{id}")
public ResponseEntity<String> excluir(@PathVariable Integer id){
    try{
    candy.excluir(id);
    return ResponseEntity.ok("Item excluido com sucesso");
    } catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir o item");
    }
}
@PostMapping("/doces/alterar")
public String editarDoces(@RequestBody Doces doce){
    candy.alterar(doce);
    return "redirect:/doces.html";
}
}
