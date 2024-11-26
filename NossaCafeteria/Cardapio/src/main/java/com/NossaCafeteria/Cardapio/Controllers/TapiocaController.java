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

import com.NossaCafeteria.Cardapio.DAO.TapiocaDAO;
import com.NossaCafeteria.Cardapio.Model.Tapioca;

@Controller
public class TapiocaController {
@Autowired
private TapiocaDAO tapioca;

@GetMapping("/tapiocas")
public String indexTapioca(){
    return "outros.html";
}
@GetMapping("/tapiocas/api")
@ResponseBody
public List<Tapioca> listarTapiocas(){
    return tapioca.obterTodos();
}
@PostMapping("/tapioca/salvar")
public String salvarTapioca(@RequestBody Tapioca tapiocas){
    tapioca.incluir(tapiocas);
    return "redirect:/outros.html";
}
@DeleteMapping("/tapioca/excluir/{id}")
public ResponseEntity<String> excluir(@PathVariable Integer id){
    try{
    tapioca.excluir(id);
    return ResponseEntity.ok("Item excluido com sucesso");
    } catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir o item");
    }
}
@PostMapping("/tapioca/alterar")
public String editarTapioca(@RequestBody Tapioca tapiocas){
    tapioca.alterar(tapiocas);
    return "redirect:/outros.html";
}
}
