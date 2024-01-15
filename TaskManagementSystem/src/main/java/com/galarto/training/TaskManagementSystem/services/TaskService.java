package com.galarto.training.TaskManagementSystem.services;

import com.galarto.training.TaskManagementSystem.models.Task;
import com.galarto.training.TaskManagementSystem.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task saveTask(Task task) {
        Task savedTask = taskRepository.save(task);
        if (savedTask != null) {
            return savedTask;
        }

        return null;
    }

    public Task getTask(int id) {

        if (taskRepository.existsById(id)) {
            return taskRepository.findById(id).get();
        }

        return null;
    }

    public List<Task> getAllTasks(int offset, int pageSize) {

        return taskRepository.findAll(PageRequest.of(offset, pageSize)).getContent();
    }

    public boolean deleteTask(int id) {
        try {
            taskRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}