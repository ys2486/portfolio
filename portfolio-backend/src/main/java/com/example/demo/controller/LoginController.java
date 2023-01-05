package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResultObject;
import com.example.demo.model.User;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.LoginMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
//特定のURLからしか使用しない場合は以下の*にURLを指定する
@CrossOrigin(origins = "*")
public class LoginController {

  @Autowired
  private final LoginMapper loginRepository;

  @PostMapping("/login")
  public LoginResultObject loginUser(@RequestBody LoginRequest loginRequest) {
    LoginResultObject loginResultObject = new LoginResultObject();
    String userId = loginRequest.getUserId();
    String password = loginRequest.getPassword();
    loginResultObject.setUserId(userId);
    return loginResultObject;
  }

  @GetMapping("/logintest")
  public User loginGet() {
    UserEntity userEntity = this.loginRepository.findByUserId("test");
    return userEntity.toUser();
  }

  @GetMapping("/api/test")
  public String test() {
    return "認証が成功しています";
  }

}
