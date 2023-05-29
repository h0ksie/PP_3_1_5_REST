package ru.kata.spring.crud.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.crud.rest.model.User;
import ru.kata.spring.crud.rest.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin")
public class AdminRestController {

    private final UserService userService;


    @GetMapping("/all-users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody() User user) {
        return userService.create(user);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }

    @PutMapping("/update")
    public User updateByAdmin(@RequestBody User user) {
        return userService.update(user);
    }
}
