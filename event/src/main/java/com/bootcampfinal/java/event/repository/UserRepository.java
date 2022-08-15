package com.bootcampfinal.java.event.repository;

import com.bootcampfinal.java.event.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {

    Optional<User> findByEmailIgnoreCaseAndPasswordIgnoreCase(String email, String password);
}
