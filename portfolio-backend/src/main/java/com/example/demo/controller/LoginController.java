package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
//特定のURLからしか使用しない場合は以下の*にURLを指定する
@CrossOrigin(origins = "*")
public class LoginController {

  @Operation(summary = "ログイン済み判定")
  @GetMapping("/api/islogin")
  public boolean isLogin() {
    return true;
  }

}
