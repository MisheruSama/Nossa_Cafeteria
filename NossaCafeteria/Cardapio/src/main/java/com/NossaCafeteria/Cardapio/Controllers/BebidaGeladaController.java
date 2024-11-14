package com.NossaCafeteria.Cardapio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.NossaCafeteria.Cardapio.DAO.BebidaGeladaDAO;
import com.NossaCafeteria.Cardapio.Model.BebidaGelada;

@Controller
public class BebidaGeladaController {
@Autowired
private BebidaGeladaDAO bebida;

@GetMapping("/Bebidas")
public String indexBebida(){
    return "bebidas";
}
@GetMapping("/Bebidas/api")
@ResponseBody
public List<BebidaGelada> listarBebidasAPI(){
    return bebida.obterTodos();
}
@PostMapping("/Bebidas/salvar")
public String salvarBebida(@RequestBody BebidaGelada bebidasGelada){
    bebida.incluir(bebidasGelada);
    return "redirect:/Bebidas";
}
@PostMapping("/Bebidas/excluir")
public String excluirBebida(@RequestBody Integer id){
    bebida.excluir(id);
    return "redirect:/Bebidas";
}
@PostMapping("/Bebidas/alterar")
public String editarBebida(@RequestBody BebidaGelada bebidasGelada){
    bebida.alterar(bebidasGelada);
    return "redirect:/Bebidas";
}
}
