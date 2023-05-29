package ru.kata.spring.crud.rest.service;

import ru.kata.spring.crud.rest.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
}
