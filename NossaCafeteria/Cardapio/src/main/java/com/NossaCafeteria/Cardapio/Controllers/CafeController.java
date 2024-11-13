package com.NossaCafeteria.Cardapio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.NossaCafeteria.Cardapio.DAO.CafeDAO;
import com.NossaCafeteria.Cardapio.Model.Cafe;

@Controller
public class CafeController {
@Autowired
private CafeDAO cafe;

@GetMapping("/Cafes")
public String indexCafe(){
    return "bebida";
}
@GetMapping("/Cafes/api")
@ResponseBody
public List<Cafe> listarCafes(){
    return cafe.obterTodos();
}
@PostMapping("/Cafes/salvar")
public String salvarCafe(@RequestBody Cafe cafes){
    cafe.incluir(cafes);
    return "redirect:/Cafes";
}
@PostMapping("/Cafes/excluir")
public String excluirCafe(@RequestBody Integer id){
    cafe.excluir(id);
    return "redirect:/Cafes";
}
@PostMapping("/Cafes/alterar")
public String editarCafe(@RequestBody Cafe cafes){
    cafe.alterar(cafes);
    return "redirect:/Cafes";
}
}
