package com.example.authmockdemo.repository;

import com.example.authmockdemo.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

  UserDetails findByUsername(String username);
}
