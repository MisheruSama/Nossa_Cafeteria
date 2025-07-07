package com.NossaCafeteria.Cardapio.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/login.html")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String menu() {
        return "index";
    }

    @GetMapping("/outros.html")
    public String indexTapioca() {
        return "outros";
    }

    @GetMapping("/bebidas.html")
    public String indexBebida() {
        return "bebidas";
    }

    @GetMapping("/doces.html")
    public String indexDoces() {
        return "doces";
    }

    @GetMapping("/salgados.html")
    public String indexSalgado() {
        return "salgados";
    }

}
