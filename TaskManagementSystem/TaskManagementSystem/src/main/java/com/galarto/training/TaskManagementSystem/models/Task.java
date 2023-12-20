package com.galarto.training.TaskManagementSystem.models;

import jakarta.persistence.*;
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
    private String title;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(12)")
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(7)")
    private Priority priority;

    @Column
    private String author;

    @Column
    private String contractor;

    public Task(int id, String title, String description, Status status, Priority priority, String author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.author = author;
        this.contractor = "";
    }

    public enum Status {
        WAITING, IN_PROGRESS, DONE
    }

    public enum Priority {
        HIGH, MEDIUM, LOW
    }
}



