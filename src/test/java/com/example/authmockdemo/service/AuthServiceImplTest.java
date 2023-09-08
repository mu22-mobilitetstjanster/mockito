package com.example.authmockdemo.service;

import com.example.authmockdemo.model.AuthDetails;
import com.example.authmockdemo.repository.AuthRepository;
import com.example.authmockdemo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {

  @Mock
  UserRepository userRepository;

  @Mock
  AuthRepository authRepository;

  @InjectMocks
  AuthService authService = new AuthServiceImpl();

  @Test
  void verifyThatUserRepositoryIsUsedWhenFindingAUser() {
    var auth = AuthDetails.builder()
            .username("Kent")
            .password("abc").build();

    when(authRepository.findByUsername("Kent")).thenReturn(auth);

    authService.findUser(auth);

    verify(userRepository, times(1)).findByUsername(anyString());
  }
}