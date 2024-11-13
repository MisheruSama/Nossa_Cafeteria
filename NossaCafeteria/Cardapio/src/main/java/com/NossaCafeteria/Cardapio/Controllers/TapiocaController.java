package com.NossaCafeteria.Cardapio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.NossaCafeteria.Cardapio.DAO.TapiocaDAO;
import com.NossaCafeteria.Cardapio.Model.Tapioca;

@Controller
public class TapiocaController {
@Autowired
private TapiocaDAO tapioca;

@GetMapping("/Tapiocas")
public String indexTapioca(){
    return "ProjetoCardapio/outros";
}
@GetMapping("/Tapiocas/api")
@ResponseBody
public List<Tapioca> listarTapiocas(){
    return tapioca.obterTodos();
}
@PostMapping("/Tapioca/salvar")
public String salvarTapioca(@RequestBody Tapioca tapiocas){
    tapioca.incluir(tapiocas);
    return "redirect:/Tapioca";
}
@PostMapping("/Tapioca/excluir")
public String excluir(@RequestBody Integer id){
    tapioca.excluir(id);
    return "redirect:/Tapioca";
}
@PostMapping("/Tapioca/alterar")
public String editarTapioca(@RequestBody Tapioca tapiocas){
    tapioca.alterar(tapiocas);
    return "redirect:/Tapioca";
}
}
