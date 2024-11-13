package com.NossaCafeteria.Cardapio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.NossaCafeteria.Cardapio.Model.Acai;
import com.NossaCafeteria.Cardapio.AcaiDAO;


@RestController
public class AcaiController {
@Autowired
private AcaiDAO acai;

@GetMapping("/Acai")
public List<Acai> listar(){
    return acai.obterTodos();
}
@PostMapping("/Acai/salvar")
public String salvarAcai(@RequestBody Acai saveAcai){
   acai.incluir(saveAcai);
   return "redirect:Acai";
}
@PostMapping("/Acai/excluir")
public String exluirAcai(@RequestBody Integer id){
    acai.excluir(id);
        return "redirect:/Acai";
}
@PostMapping("/Acai/alterar")
public String editarAcai(@RequestBody Acai editAcai){
    acai.alterar(editAcai);
    return "redirect:/Acai";
}
}

