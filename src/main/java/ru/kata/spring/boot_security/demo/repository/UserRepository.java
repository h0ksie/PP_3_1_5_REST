package ru.kata.spring.boot_security.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    void deleteById(Long id);

    @Query("select u from User u join fetch u.roles where u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

}