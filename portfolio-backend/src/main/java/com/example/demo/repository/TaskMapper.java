package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.Task;

@Mapper
public interface TaskMapper {

  // タスク全取得
  public List<Task> selectTasks(String createdUser);

  // タスク登録
  public int insertTask(@Param("task") Task task);

  // タスク削除
  public int deleteTask(@Param("task") Task task);

  // タスク更新
  public int updateTask(@Param("task") Task task);

  // タスク完了・未完了戻し
  public int updateTaskCompleted(@Param("task") Task task);

}
