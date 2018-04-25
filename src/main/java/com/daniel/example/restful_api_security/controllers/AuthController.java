package com.daniel.example.restful_api_security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class AuthController {

    @GetMapping(value = {"/login", "/"})
    public String loginPage(Principal principal) {
        if(principal == null)
            return "/login";
        else
            return "redirect:/user/";
    }


}
