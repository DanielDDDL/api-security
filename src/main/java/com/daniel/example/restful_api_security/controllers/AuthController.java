package com.daniel.example.restful_api_security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping(value = {"/login", "/"})
    public String loginPage() {
        return "/login";
    }


}
