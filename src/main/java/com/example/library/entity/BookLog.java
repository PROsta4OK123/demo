package com.example.library.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table
public class BookLog {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 255, nullable = false)
    Long id;

    @Column(nullable = false, length = 255)
    Long userId;

    @Column(nullable = false)
    String bookName;
}
