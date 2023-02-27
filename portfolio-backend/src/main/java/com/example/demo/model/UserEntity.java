package com.example.demo.model;

import java.util.Date;

import lombok.Data;

@Data
public class UserEntity {
  private int userId;
  private String mailAddress;
  private String userName;
  private String password;
  private Date createdAt;

}
