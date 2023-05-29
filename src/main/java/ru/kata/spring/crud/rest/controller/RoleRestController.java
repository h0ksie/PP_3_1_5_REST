package ru.kata.spring.crud.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.crud.rest.model.Role;
import ru.kata.spring.crud.rest.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@AllArgsConstructor
public class RoleRestController {
    private final RoleService roleService;

    @GetMapping(value = "/all-roles")
    public List<Role> findAll() {
        return roleService.findAll();
    }
}
