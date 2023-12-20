package com.galarto.training.TaskManagementSystem.controllers;

import com.galarto.training.TaskManagementSystem.models.Task;
import com.galarto.training.TaskManagementSystem.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {
    @Autowired
    private TaskRepository taskRepo;

    @PostMapping("/addtask")
    public String addTask(@RequestParam(name = "id") String id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "priority") String priority,
            @RequestParam(name = "author") String author) {
        taskRepo.save(new Task(Integer.parseInt(id), title, description, Task.Status.WAITING,
                Task.Priority.valueOf(priority), author));
        return "redirect:/";
    }

    @GetMapping("/findtask")
    public String findTask(@RequestParam(name = "id") String id) {
        System.out.println(taskRepo.findById(Long.valueOf(id)));
        return "redirect:/";
    }

    @DeleteMapping("/deletetask")
    public String deleteTask(@RequestParam(name = "id") long id) {
        taskRepo.deleteById(id);
        return "redirect:/";
    }

    @PutMapping("/update")
    public String updateTask(@RequestParam(name = "id") int id,
                             @RequestParam(name = "title") String title,
                             @RequestParam(name = "description") String description,
                             @RequestParam(name = "status") String status,
                             @RequestParam(name = "priority") String priority,
                             @RequestParam(name = "author") String author,
                             @RequestParam(name = "contractor") String contractor) {
        Task task = new Task(id, title, description, Task.Status.valueOf(status), Task.Priority.valueOf(priority),
                            author, contractor);
        taskRepo.save(task);
        return "redirect:/";
    }
}
