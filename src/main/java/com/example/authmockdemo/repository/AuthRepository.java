package com.example.authmockdemo.repository;

import com.example.authmockdemo.model.AuthDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AuthDetails, Long> {

  AuthDetails findByUsername(String username);
}
