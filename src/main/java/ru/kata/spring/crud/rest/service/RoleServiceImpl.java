package ru.kata.spring.crud.rest.service;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import ru.kata.spring.crud.rest.model.Role;
import ru.kata.spring.crud.rest.repository.RoleRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
