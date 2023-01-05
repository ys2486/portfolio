package com.example.demo.model;

import lombok.Data;

@Data
public class UserEntity {
  private int id;
  private String userId;
  private String password;
  private String userName;

  public User toUser() {
    return new User(userId, userName);
  }

}
