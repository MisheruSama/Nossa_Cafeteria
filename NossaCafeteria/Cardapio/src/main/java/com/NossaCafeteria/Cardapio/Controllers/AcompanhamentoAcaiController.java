package com.NossaCafeteria.Cardapio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.NossaCafeteria.Cardapio.DAO.AcompanhamentoAcaiDAO;
import com.NossaCafeteria.Cardapio.Model.AcompanhamentoAcai;

@Controller
public class AcompanhamentoAcaiController {
@Autowired
private AcompanhamentoAcaiDAO acompanhamento;


@GetMapping("/Acompanhamento/api")
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
