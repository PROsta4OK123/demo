package com.example.library.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GeneratedColumn;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "book")
public class Book {
    public Book(String name, String createYear, String description) {
        this.name = name;
        this.createYear = createYear;
        this.description = description;
    }

    public Book() {
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 255, nullable = false)

    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "year", nullable = false)
    private String createYear;
    @Column(nullable = false)
    private String description;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateYear() {
        return createYear;
    }

    public void setCreateYear(String createYear) {
        this.createYear = createYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
