package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.UserEntity;

@Mapper
public interface LoginMapper {

  // ログイン処理
  public UserEntity findBymailAddress(String mailAddress);

}
