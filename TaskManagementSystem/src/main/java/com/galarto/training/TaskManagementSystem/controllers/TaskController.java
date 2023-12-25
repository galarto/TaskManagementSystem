package com.galarto.training.TaskManagementSystem.controllers;

import com.galarto.training.TaskManagementSystem.models.Task;

import com.galarto.training.TaskManagementSystem.models.User;
import com.galarto.training.TaskManagementSystem.services.TaskService;
import com.galarto.training.TaskManagementSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @PostMapping("/task/{id}")
    public void addTask(@RequestBody Task task,
                        @PathVariable(name = "id") int userId) {

        userService.getUser(userId);
        System.out.println(task);
        task.setContractor(userService.findUserByEmail(task.getContractor().getEmail()));
        task.setAuthor(userService.findUserByEmail(task.getAuthor().getEmail()));
        taskService.addTask(task);
    }

    @PutMapping("/tasks")
    public Task updateTask(@RequestBody Task task) {

        taskService.updateTask(task);
        return task;
    }

    @GetMapping("/tasks/{id}")
    public Task findTask(@PathVariable int id) {
        Task task = taskService.getTask(id);

        return task;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();

        return tasks;
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }
}
