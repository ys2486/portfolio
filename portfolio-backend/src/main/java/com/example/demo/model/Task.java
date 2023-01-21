package com.example.demo.model;

import java.util.Date;

import lombok.Data;

//@Getter
//@Setter
@Data
public class Task {

  private Long id;

  private String name;

  private Boolean completed;

  private Date createdAt;

  private Date updatedAt;

  private String createdUser;
}
