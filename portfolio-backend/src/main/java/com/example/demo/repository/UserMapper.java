package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.UserEntity;
import com.example.demo.model.UserForm;

@Mapper
public interface UserMapper {

  // ユーザー登録
  public int registerUser(@Param("registerUser") UserForm userForm);

  // ユーザー情報取得
  public UserEntity getUserInfo(String loginUserMailAddress);

}
