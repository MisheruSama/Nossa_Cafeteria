package com.NossaCafeteria.Cardapio.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String menu() {
        return "index";
    }

    @GetMapping("/outros")
    public String indexTapioca() {
        return "outros";
    }

    @GetMapping("/bebidas")
    public String indexBebida() {
        return "bebidas";
    }

    @GetMapping("/doces")
    public String indexDoces() {
        return "doces";
    }

    @GetMapping("/salgados")
    public String indexSalgado() {
        return "salgados";
    }

}
