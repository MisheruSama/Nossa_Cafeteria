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

import com.NossaCafeteria.Cardapio.DAO.AcaiDAO;
import com.NossaCafeteria.Cardapio.Model.Acai;


@Controller
public class AcaiController {
@Autowired
private AcaiDAO acai;

@GetMapping("/acai")
public String indexAcai(){
    return "outros.html";
}

@GetMapping("/acai/api")
@ResponseBody
public List<Acai> listar(){
    return acai.obterTodos();
}
@PostMapping("/acai/salvar")
public String salvarAcai(@RequestBody Acai saveAcai){
   acai.incluir(saveAcai);
   return "redirect:/outros.html";
}
@DeleteMapping("/acai/excluir/{id}")
public ResponseEntity<String> exluirAcai(@PathVariable Integer id){
    try{
    acai.excluir(id);
        return ResponseEntity.ok("Item excluido com sucesso");
    } catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir o item");
    }
}
@PostMapping("/acai/alterar")
public String editarAcai(@RequestBody Acai editAcai){
    acai.alterar(editAcai);
    return "redirect:/outros.html";
}
}

