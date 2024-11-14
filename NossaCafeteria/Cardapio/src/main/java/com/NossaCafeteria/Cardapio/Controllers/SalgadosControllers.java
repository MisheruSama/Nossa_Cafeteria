package com.NossaCafeteria.Cardapio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.NossaCafeteria.Cardapio.DAO.SalgadosDAO;
import com.NossaCafeteria.Cardapio.Model.Salgados;

@Controller
public class SalgadosControllers {

@Autowired
private SalgadosDAO salgados;

@GetMapping("/salgados")
public String indexSalgado(){
    return "salgados";
}

@GetMapping("/salgados/api")
@ResponseBody
public List<Salgados> listarSalgados(){
    return salgados.obterTodos();
}
@PostMapping("/salgados/salvar")
public String salvarSalgado(@RequestBody Salgados salgado){
    salgados.incluir(salgado);
    return "redirect:/salgados";
}
@PostMapping("/salgados/excluir")
public String excluirSalgado(@RequestBody Integer id){
    salgados.excluir(id);
    return "redirect:/salgados";
}
@PostMapping("/salgados/alterar")
public String editarSalgado(@RequestBody Salgados salgado){
    salgados.alterar(salgado);
    return "redirect:/salgados";
}
}
