package com.example.demo.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserEntity;
import com.example.demo.model.UserForm;
import com.example.demo.repository.UserMapper;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
public class UserController {

  private final UserMapper userMapper;

  private final BCryptPasswordEncoder passwordEncoder;

  @Operation(summary = "ユーザー新規作成")
  @PostMapping("/api/user/register")
  public int registerUser(@RequestBody UserForm userForm) {
    // パスワードハッシュ化
    userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
    return userMapper.registerUser(userForm);
  }

  @GetMapping("/api/user/getUserInfo")
  public UserEntity getUserInfo(@RequestParam("loginUserMailAddress") String loginUserMailAddress) {
    return userMapper.getUserInfo(loginUserMailAddress);
  }

}
