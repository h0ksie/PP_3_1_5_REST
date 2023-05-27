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

import java.util.HashMap;
import java.util.Map;

@Controller
@AllArgsConstructor
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/admin")
    public String findAll(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("user", userService.findByEmail(userDetails.getUsername()));
        model.addAttribute("users", userService.findAll());
        model.addAttribute("roles", roleService.findAll());
        return "admin";
    }

    @PostMapping("/admin/create")
    public String create(@ModelAttribute User user) {
        userService.create(user);
        return "redirect:/admin";
    }

    @PostMapping("/admin/delete")
    public String delete(@ModelAttribute User user) {
        userService.delete(user);
        return "redirect:/admin";
    }

    @PostMapping("/admin/update")
    public String updateByAdmin(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/userinfo/{id}")
    @ResponseBody
    public User getUserModalById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

}
