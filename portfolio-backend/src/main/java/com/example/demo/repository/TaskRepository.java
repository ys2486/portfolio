package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Task;

@Mapper
public interface TaskRepository {

  // タスク取得
  public List<Task> findTask();

}
