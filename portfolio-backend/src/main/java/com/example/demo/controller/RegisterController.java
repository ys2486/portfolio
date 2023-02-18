package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserForm;
import com.example.demo.repository.RegisterMapper;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
public class RegisterController {

  private final RegisterMapper repository;

  @Operation(summary = "ユーザー新規作成")
  @PostMapping("/api/register")
  public int registerUser(@RequestBody UserForm userForm) {
    return repository.registerUser(userForm);
  }
}
