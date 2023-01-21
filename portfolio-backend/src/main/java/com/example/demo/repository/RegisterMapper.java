package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.UserForm;

@Mapper
public interface RegisterMapper {

  // ユーザー登録
  public int registerUser(@Param("RegisterUser") UserForm userForm);

}
