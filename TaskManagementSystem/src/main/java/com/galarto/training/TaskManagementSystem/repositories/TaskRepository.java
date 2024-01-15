package com.galarto.training.TaskManagementSystem.repositories;

import com.galarto.training.TaskManagementSystem.models.Task;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
