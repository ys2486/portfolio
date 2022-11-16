package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.model.TaskName;
import com.example.demo.repository.TaskMapper;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

//@RequestMapping("api/tasks")
@RequiredArgsConstructor
@RestController
//特定のURLからしか使用しない場合は以下の*にURLを指定する
@CrossOrigin(origins = "*")
public class TaskController {

  private final TaskMapper repository;

  @Operation(summary = "タスクを全件取得します")
  @GetMapping("/tasks")
  public List<Task> selectTasks() {
    return repository.selectTasks();
  }

  @Operation(summary = "タスクを登録します")
  @PostMapping("/tasks")
  public int insertTask(@RequestBody TaskName taskName) {
    return repository.insertTask(taskName);
  }

  @Operation(summary = "タスクを登録します")
  @DeleteMapping("/tasks")
  public int deleteTask(@RequestBody Task task) {
    return repository.deleteTask(task);
  }

  @GetMapping("/test")
  public String test() {
    return "testaaaa";
  }

}
