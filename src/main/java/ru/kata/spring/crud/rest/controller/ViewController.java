package ru.kata.spring.crud.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class ViewController {

    @GetMapping("/admin")
    public String findAll() {
        return "admin";
    }

    @GetMapping("/user")
    public String findUser() {
        return "user_page";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
