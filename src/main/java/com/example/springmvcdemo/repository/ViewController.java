package com.example.springmvcdemo.repository;

import com.example.springmvcdemo.service.PersonService;
import com.example.springmvcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/view")
@Controller
public class ViewController {

    @Autowired
    PersonService personService;

    @GetMapping
    String getPersonView(@RequestParam("user_id") int userId, Model model) {
        var personToView = personService.getPerson(userId);
        model.addAttribute("person", personToView);
        return "viewPerson";
    }

}
