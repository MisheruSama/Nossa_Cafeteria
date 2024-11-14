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

@GetMapping("/tapiocas")
public String indexTapioca(){
    return "outros";
}
@GetMapping("/tapiocas/api")
@ResponseBody
public List<Tapioca> listarTapiocas(){
    return tapioca.obterTodos();
}
@PostMapping("/tapioca/salvar")
public String salvarTapioca(@RequestBody Tapioca tapiocas){
    tapioca.incluir(tapiocas);
    return "redirect:/tapioca";
}
@PostMapping("/tapioca/excluir")
public String excluir(@RequestBody Integer id){
    tapioca.excluir(id);
    return "redirect:/tapioca";
}
@PostMapping("/tapioca/alterar")
public String editarTapioca(@RequestBody Tapioca tapiocas){
    tapioca.alterar(tapiocas);
    return "redirect:/tapioca";
}
}
