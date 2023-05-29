package ru.kata.spring.crud.rest.service;

import ru.kata.spring.crud.rest.model.User;

import java.util.List;

public interface UserService {
    User create(User user);

    List<User> findAll();

    User update(User user);

    void delete(User user);

    User findById(Long id);

    User findByEmail(String email);
}
