package com.galarto.training.TaskManagementSystem.controllers;

import com.galarto.training.TaskManagementSystem.models.Task;


import com.galarto.training.TaskManagementSystem.services.TaskService;
import com.galarto.training.TaskManagementSystem.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @PostMapping("/task")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {

        Task savedTask = taskService.saveTask(task);
        if(savedTask != null) {
            log.info("Сохранена таска с id{}" + task.getId());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/task")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        Task savedTask = taskService.saveTask(task);
        if(savedTask != null) {
            log.info("Обновлена таска с id{}" + task.getId());
            return ResponseEntity.ok(savedTask);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> findTask(@PathVariable int id) {

        Task task = taskService.getTask(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/tasks/{pagesize}/{offset}")
    public ResponseEntity<List<Task>> getAllTasks(@PathVariable int pageSize, @PathVariable int offset) {

        List<Task> tasks = taskService.getAllTasks(offset, pageSize);
        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable int id) {

        var isRemoved = taskService.deleteTask(id);
        if(!isRemoved) {
            return ResponseEntity.notFound().build();
        }
        log.info("Удалена таска с id{}" + id);
        return ResponseEntity.noContent().build();
    }
}
