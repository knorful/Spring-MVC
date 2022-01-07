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
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getLoginForm(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "loginForm";
    }

    @PostMapping
    public String login(@ModelAttribute User user) {
        System.out.println("user = " + user.getEmail());
        var foundUserId = userService.loginUser(user.getEmail(), user.getPassword());
        return String.format("redirect:/contacts/%s", foundUserId);
    }

}
