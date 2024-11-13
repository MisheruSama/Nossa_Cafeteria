package com.NossaCafeteria.Cardapio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.NossaCafeteria.Cardapio.DAO.SanduicheDAO;
import com.NossaCafeteria.Cardapio.Model.Sanduiche;
@Controller
public class SanduicheController {
@Autowired
private SanduicheDAO sanduiche;

@GetMapping("/Sanduiches")
public String indexSanduiche(){
    return "salgados";
}
@GetMapping("/Sanduiches/api")
@ResponseBody
public List<Sanduiche> listarSanduiches(){
    return sanduiche.obterTodos();
}
@PostMapping("/Sanduiche/salvar")
public String salvar(@RequestBody Sanduiche sanduiches){
    sanduiche.incluir(sanduiches);
    return "redirect:/Sanduiches";
}
@PostMapping("/Sanduiches/excluir")
public String excluir(@RequestBody Integer id){
    sanduiche.excluir(id);
    return "redirect:/Sanduiches";
}
@PostMapping("/Sanduiches/alterar")
public String editar(@RequestBody Sanduiche sanduiches){
    sanduiche.alterar(sanduiches);
    return "redirect:/Sanduiches";
}
}
