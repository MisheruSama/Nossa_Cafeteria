package com.NossaCafeteria.Cardapio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.NossaCafeteria.Cardapio.Model.AcompanhamentoAcai;
import com.NossaCafeteria.Cardapio.DAO.AcompanhamentoAcaiDAO;

@RestController
public class AcompanhamentoAcaiController {
@Autowired
private AcompanhamentoAcaiDAO acompanhamento;

@GetMapping("/Acompanhamento")
public List<AcompanhamentoAcai> listarAcompanhamentos(){
    return acompanhamento.obterTodos();
}
@PostMapping("/Acompanhamento/novo")
public String salvar(@RequestBody AcompanhamentoAcai saveAcompanhamento){
    acompanhamento.incluir(saveAcompanhamento);
    return "redirect:/Acompanhamento";
}
@PostMapping("/Acompanhamento/excluir")
public String excluirAcompanhamento(@RequestBody Integer id){
    acompanhamento.excluir(id);
    return "redirect:/Acompanhamento";
}
@PostMapping("/Acompanhamento/editar")
public String editarAcompanhamento(@RequestBody AcompanhamentoAcai editAcompanhamento){
    acompanhamento.alterar(editAcompanhamento);
    return "redirect:/Acompanhamento";
}
}
