package com.galarto.training.TaskManagementSystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private String email;

    @OneToMany(mappedBy = "contractor")
    private List<Task> contractorTasks;

    @OneToMany(mappedBy = "author")
    private List<Task> authorTasks;
}
