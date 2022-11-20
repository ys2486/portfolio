package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.Task;
import com.example.demo.model.TaskName;

@Mapper
public interface TaskMapper {

  // タスク全取得
  public List<Task> selectTasks();

  // タスク登録
  public int insertTask(TaskName taskName);

  // タスク削除
  public int deleteTask(@Param("task") Task task);

  // タスク更新
  public int updateTask(@Param("task") Task task);

}
