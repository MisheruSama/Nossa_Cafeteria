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

@GetMapping("/Salgado")
public String indexSalgado(){
    return "salgados";
}

@GetMapping("/Salgado/api")
@ResponseBody
public List<Salgados> listarSalgados(){
    return salgados.obterTodos();
}
@PostMapping("/Salgado/salvar")
public String salvarSalgado(@RequestBody Salgados salgado){
    salgados.incluir(salgado);
    return "redirect:/Salgado";
}
@PostMapping("/Salgado/excluir")
public String excluirSalgado(@RequestBody Integer id){
    salgados.excluir(id);
    return "redirect:/Salgado";
}
@PostMapping("/Salgado/alterar")
public String editarSalgado(@RequestBody Salgados salgado){
    salgados.alterar(salgado);
    return "redirect:/Salgado";
}
}
