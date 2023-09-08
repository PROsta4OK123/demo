package com.example.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@Table
public class Book {
    public Book() {
    }

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id", length = 255, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "year", nullable = false)
    private String createYear;

    @Column(nullable = false)
    private String description;

    @OneToOne
    BookLog bookLog;
}
