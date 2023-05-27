package ru.kata.spring.boot_security.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user")
    public String findUser(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("user", userService.findByEmail(userDetails.getUsername()));
        return "user_page";
    }
}