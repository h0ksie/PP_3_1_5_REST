package ru.kata.spring.crud.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.crud.rest.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
