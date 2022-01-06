package com.example.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class PersonController {

    @GetMapping
    String getPeople(Model model) {
        model.addAttribute("something", "from controller");
        model.addAttribute("people", Arrays.asList(
                new Person("Kris", "123 Apple Dr", "apt 2", "Sep 11 1987"),
                new Person("Alice", "123 Banana Dr", "apt 3", "Sep 11 2000"),
                new Person("Jon", "123 Orange Dr", "apt 4", "Sep 11 1987")
        ));
        return "people";
    }

}
