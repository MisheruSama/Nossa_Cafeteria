package com.NossaCafeteria.Cardapio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.NossaCafeteria.Cardapio.DAO.DocesDAO;
import com.NossaCafeteria.Cardapio.Model.Doces;

@Controller
public class DocesControllers {
@Autowired
private DocesDAO candy;

@GetMapping("/doces")
public String indexDoces(){
    return "doces";
}
@GetMapping("/doces/api")
@ResponseBody
public List<Doces> listarDoces(){
return candy.obterTodos();
}
@PostMapping("/doces/salvar")
public String salvarDoces(@RequestBody Doces doce){
    candy.incluir(doce);
    return "redirect:/doces";
}
@PostMapping("/doces/excluir")
public String excluir(@RequestBody Integer id){
    candy.excluir(id);
    return "redirect:/doces";
}
@PostMapping("/doces/alterar")
public String editarDoces(@RequestBody Doces doce){
    candy.alterar(doce);
    return "redirect:/doces";
}
}
