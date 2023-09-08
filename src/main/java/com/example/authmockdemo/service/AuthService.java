package com.example.authmockdemo.service;

import com.example.authmockdemo.model.AuthDetails;
import com.example.authmockdemo.model.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
  boolean authenticate(String username, String password);
  UserDetails findUser(AuthDetails auth);
}
