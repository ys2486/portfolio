package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserEntity;
import com.example.demo.repository.LoginMapper;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  @Autowired
  private LoginMapper loginMapper;

  @Override
  public UserDetails loadUserByUsername(String mailAddress) throws UsernameNotFoundException {
    try {
      // メールアドレスを元に、ユーザー情報を取得する
      UserEntity entity = loginMapper.findBymailAddress(mailAddress);

      // org.springframework.security.core.userdetails.Userにして返却する
      // 既にパスワードはハッシュ化済みのため、エンコードかけずにそのまま渡す
      return new User(entity.getMailAddress(), entity.getPassword(), new ArrayList<>());
    } catch (Exception e) {
      throw new UsernameNotFoundException("ユーザーが見つかりません");
    }
  }

}
