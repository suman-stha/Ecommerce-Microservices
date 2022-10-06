package com.customerservice.repository;

import com.customerservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByCredentialUsername(final String username);
}
