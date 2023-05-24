package ru.kata.spring.boot_security.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/user")
    public String findUser(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("user", userService.findByEmail(userDetails.getUsername()));
        return "user_page";
    }

    @GetMapping("/user/edit")
    public String editByUser(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("user", userService.findByEmail(userDetails.getUsername()));
        model.addAttribute("roles", roleService.findAll());
        return "user_edit";
    }

    @PostMapping("/user/edit/update")
    public String updateByUser(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/user";
    }
}