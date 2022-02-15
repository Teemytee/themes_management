package com.example.springthymeleaf.repository;

import com.example.springthymeleaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String login);
    User findUserByEmail(String email);
}
