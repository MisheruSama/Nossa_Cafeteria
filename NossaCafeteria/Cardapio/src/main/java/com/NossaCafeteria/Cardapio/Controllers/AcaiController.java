package com.NossaCafeteria.Cardapio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.NossaCafeteria.Cardapio.Model.Acai;
import com.NossaCafeteria.Cardapio.DAO.AcaiDAO;


@Controller
public class AcaiController {
@Autowired
private AcaiDAO acai;

@GetMapping("/outros.html")
public String indexAcai(){
    return "outros";
}

@GetMapping("/outros/api")
@ResponseBody
public List<Acai> listar(){
    return acai.obterTodos();
}
@PostMapping("/outros/salvar")
public String salvarAcai(@RequestBody Acai saveAcai){
   acai.incluir(saveAcai);
   return "redirect:/outros.html";
}
@PostMapping("/outros/excluir")
public String exluirAcai(@RequestBody Integer id){
    acai.excluir(id);
        return "redirect:/outros.html";
}
@PostMapping("/outros/alterar")
public String editarAcai(@RequestBody Acai editAcai){
    acai.alterar(editAcai);
    return "redirect:/outros";
}
}

