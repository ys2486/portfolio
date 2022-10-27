package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskMapper;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

//@RequestMapping("api/tasks")
@RequiredArgsConstructor
@RestController
public class TaskController {

  private final TaskMapper repository;

  @Operation(summary = "タスクを全件取得します")
  @GetMapping("/tasks")
  public List<Task> findTaskAll() {
    return repository.findTask();
  }

  @GetMapping("/test")
  public String test() {
    return "test";
  }

}
