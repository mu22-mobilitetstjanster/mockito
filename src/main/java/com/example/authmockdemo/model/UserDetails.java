package com.example.authmockdemo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetails {

  private String username;
  private String role;
  private String alias;
}
