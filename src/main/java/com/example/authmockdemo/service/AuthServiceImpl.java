package com.example.authmockdemo.service;

import com.example.authmockdemo.model.AuthDetails;
import com.example.authmockdemo.model.UserDetails;
import com.example.authmockdemo.repository.AuthRepository;
import com.example.authmockdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authService")
public class AuthServiceImpl implements AuthService {

  @Autowired
  AuthRepository authRepository;

  @Autowired
  UserRepository userRepository;

  @Override
  public boolean authenticate(String username, String password) {
    AuthDetails auth = authRepository.findByUsername(username);

    return auth.getPassword().equals(password);
  }

  @Override
  public UserDetails findUser(AuthDetails auth) {
    var username = auth.getUsername();
    var password = auth.getPassword();

    if(authenticate(username, password)) {
      return userRepository.findByUsername(username);
    } else {
      return null;
    }
  }
}
