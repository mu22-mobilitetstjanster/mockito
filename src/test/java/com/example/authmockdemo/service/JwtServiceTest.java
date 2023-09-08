package com.example.authmockdemo.service;

import com.example.authmockdemo.model.AuthDetails;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@SpringBootTest (behövs endast då man använder spring IOC, ex. autowire)
@ExtendWith(MockitoExtension.class)
class JwtServiceTest {

  @Mock
  AuthService authService;

  @InjectMocks
  JwtService jwtService;

  @Test
  void getToken() {
    var auth = AuthDetails.builder()
            .username("greta")
            .password("123").build();

    when(authService.authenticate("greta", "123"))
            .thenReturn(true);

    var token = jwtService.getToken(auth);

    assertNotNull(token);
  }
}