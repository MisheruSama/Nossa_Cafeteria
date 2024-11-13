package com.NossaCafeteria.Cardapio.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.NossaCafeteria.Cardapio.DAO.DocesDAO;
import com.NossaCafeteria.Cardapio.Model.Doces;

@Controller
public class DocesControllers {
@Autowired
private DocesDAO candy;

@GetMapping("/Doces")
public String indexDoces(){
    return "doces";
}
@GetMapping("/Doces/api")
public List<Doces> listarDoces(){
return candy.obterTodos();
}
@PostMapping("/Doces/salvar")
public String salvarDoces(@RequestBody Doces doce){
    candy.incluir(doce);
    return "redirect:/Doces";
}
@PostMapping("/Doces/excluir")
public String excluir(@RequestBody Integer id){
    candy.excluir(id);
    return "redirect:/Doces";
}
@PostMapping("/Doces/alterar")
public String editarDoces(@RequestBody Doces doce){
    candy.alterar(doce);
    return "redirect:/Doces";
}
}
