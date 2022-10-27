package com.example.demo.model;

import lombok.Data;

//@Getter
//@Setter
@Data
public class Task {

  private Long id;

  private String name;

  private Boolean completed = false;

}
