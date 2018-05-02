package com.daniel.example.restful_api_security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String helloAdminPage(ModelMap modelMap) {
        modelMap.addAttribute("message", "Hello, admin!");
        return "hello";
    }

}
