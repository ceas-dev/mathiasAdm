package com.easyapp.mathias.adm.mathias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping(path = {"account", "account/login"})
    public String login(){
        return "account/login.html";
    }

}
