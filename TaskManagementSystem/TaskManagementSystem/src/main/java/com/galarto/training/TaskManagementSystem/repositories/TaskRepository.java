package com.galarto.training.TaskManagementSystem.repositories;

import com.galarto.training.TaskManagementSystem.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Task save(Task task);

    Optional<Task> findById(Long id);

    void delete(Task task);
    void deleteById(Long aLong);

    void flush();
}
