package com.daniel.example.restful_api_security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String helloUserPage(ModelMap modelMap) {
        modelMap.addAttribute("message", "Hello, user!");
        return "hello";
    }

}
