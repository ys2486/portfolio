package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskMapper;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
//特定のURLからしか使用しない場合は以下の*にURLを指定する
@CrossOrigin(origins = "*")
public class TaskController {

  private final TaskMapper repository;

  @Operation(summary = "ユーザーに紐付いたタスク全件取得")
  @GetMapping("/api/tasks/get")
  public List<Task> selectTasks(@RequestParam("createdUser") String createdUser) {
    return repository.selectTasks(createdUser);
  }

  @Operation(summary = "タスク新規登録")
  @PostMapping("/api/tasks/post")
  public int insertTask(@RequestBody Task task) {
    return repository.insertTask(task);
  }

  @Operation(summary = "タスク削除")
  @DeleteMapping("/api/tasks/delete")
  public int deleteTask(@RequestBody Task task) {
    return repository.deleteTask(task);
  }

  @Operation(summary = "タスク内容更新")
  @PutMapping("/api/tasks/put")
  public int updateTask(@RequestBody Task task) {
    return repository.updateTask(task);
  }

  @Operation(summary = "タスクを完了・未完了")
  @PutMapping("/api/tasks/put/complete")
  public int updateTaskCompleted(@RequestBody Task task) {
    return repository.updateTaskCompleted(task);
  }

  @GetMapping("/test")
  public String test() {
    return "testaaaa";
  }

}
