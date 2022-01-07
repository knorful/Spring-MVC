package com.example.springmvcdemo.controller;

import com.example.springmvcdemo.entity.User;
import com.example.springmvcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getRegisterForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registerForm";
    }

    @PostMapping
    public String userRegister(@ModelAttribute User user) {
        userService.registerUser(user);
        System.out.println("register user " + user);
        return String.format("redirect:/contacts/%s", user.getId());
    }

}
