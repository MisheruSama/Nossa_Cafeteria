package com.NossaCafeteria.Cardapio.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.NossaCafeteria.Cardapio.DocesDAO;
import com.NossaCafeteria.Cardapio.Doces;

@RestController
public class DocesControllers {
@Autowired
private DocesDAO candy;

@GetMapping("Doces")
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
