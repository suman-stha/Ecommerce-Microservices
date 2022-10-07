package com.customerservice.repository;

import com.customerservice.entities.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<Credential,Integer> {
    Optional<Credential> findByUsername(final String username);
}
