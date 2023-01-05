package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserEntity;
import com.example.demo.repository.LoginMapper;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  @Autowired
  private LoginMapper loginRepository;

  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    try {
      UserEntity entity = loginRepository.findByUserId(userId);
      // 認可があればここで設定できる
      // org.springframework.security.core.userdetails.Userにして返却する
      // パスワードエンコーダを利用してパスワードはエンコードをかける
      return new User(entity.getUserId(),
          PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(entity.getPassword()), new ArrayList<>());
    } catch (Exception e) {
      throw new UsernameNotFoundException("ユーザーが見つかりません");
    }
  }

}
