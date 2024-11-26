package com.NossaCafeteria.Cardapio.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MenuController {

@GetMapping("/")
public String login(){
    return "login.html";
}
@GetMapping("/index.html")
public String menu(){
    return "index.html";
}
}
