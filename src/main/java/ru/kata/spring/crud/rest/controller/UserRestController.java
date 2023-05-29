package ru.kata.spring.crud.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.crud.rest.model.User;
import ru.kata.spring.crud.rest.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserRestController {
    private final UserService userService;

    @GetMapping(value = "/user")
    public User findCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        return userService.findByEmail(userDetails.getUsername());
    }
}
