package com.NossaCafeteria.Cardapio.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

@GetMapping("/")
public String index(){
    return "index.html";
}
}
