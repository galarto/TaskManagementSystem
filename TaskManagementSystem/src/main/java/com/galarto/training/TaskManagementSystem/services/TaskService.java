package com.galarto.training.TaskManagementSystem.services;

import com.galarto.training.TaskManagementSystem.models.Task;
import com.galarto.training.TaskManagementSystem.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(Task task) {
        taskRepository.saveAndFlush(task);
    }

    public Task getTask(int id) {
        Task task = null;
        Optional<Task> optional = taskRepository.findById(id);
        if(optional.isPresent()) {
            task = optional.get();
        }
        return task;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
