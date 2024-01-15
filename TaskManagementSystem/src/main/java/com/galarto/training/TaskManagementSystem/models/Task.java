package com.galarto.training.TaskManagementSystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    @Size(min = 1, message = "Напишите название задачи")
    private String title;

    @Column
    @NotNull
    @Size(min = 1, message = "Напишите описание задачи")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(12)")
    @NotNull
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(7)")
    @NotNull
    private Priority priority;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "author_id")
    @NotNull
    private User author;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "contractor_id")
    private User contractor;

    public Task(int id, String title, String description, Status status, Priority priority, User author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.author = author;
        this.contractor = new User();
    }

    public enum Status {
        WAITING, IN_PROGRESS, DONE
    }

    public enum Priority {
        HIGH, MEDIUM, LOW
    }
}



