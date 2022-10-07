package com.customerservice.repository;

import com.customerservice.entities.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Integer> {
}
