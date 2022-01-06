package com.example.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping
    String getIndex(Model model) {
        model.addAttribute("something", "this is from the controller");
        return "index";
    }

}
