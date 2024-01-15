package com.galarto.training.TaskManagementSystem.models;

import com.galarto.training.TaskManagementSystem.domain.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

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
    private String login;

    @Column
    private String password;

    @Column
    @NotNull
    private String email;

    private Set<Role> roles;

    @OneToMany(mappedBy = "contractor")
    private List<Task> contractorTasks;

    @OneToMany(mappedBy = "author")
    private List<Task> authorTasks;
}
