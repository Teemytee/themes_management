package com.example.springthymeleaf.repository;

import com.example.springthymeleaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String login);
}
