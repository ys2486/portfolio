package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Data
public class Task {

  private Long id;

  private String name;

  private Boolean completed = false;

}
