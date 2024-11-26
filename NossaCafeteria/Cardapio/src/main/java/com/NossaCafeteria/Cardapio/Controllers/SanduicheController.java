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

import com.NossaCafeteria.Cardapio.DAO.SanduicheDAO;
import com.NossaCafeteria.Cardapio.Model.Sanduiche;
@Controller
public class SanduicheController {
@Autowired
private SanduicheDAO sanduiche;


@GetMapping("/sanduiches/api")
@ResponseBody
public List<Sanduiche> listarSanduiches(){
    return sanduiche.obterTodos();
}
@PostMapping("/sanduiches/salvar")
public String salvar(@RequestBody Sanduiche sanduiches){
    sanduiche.incluir(sanduiches);
    return "redirect:/salgados.html";
}
@DeleteMapping("/sanduiches/excluir/{id}")
public ResponseEntity<String> excluir(@PathVariable Integer id){
    try{
    sanduiche.excluir(id);
    return ResponseEntity.ok("Item excluido com sucesso.");
    } catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir item");
    }

}
@PostMapping("/sanduiches/alterar")
public String editar(@RequestBody Sanduiche sanduiches){
    sanduiche.alterar(sanduiches);
    return "redirect:/salgados.html";
}
}
