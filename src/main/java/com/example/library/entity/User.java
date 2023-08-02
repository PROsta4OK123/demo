package com.example.library.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table
public class User {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 255, nullable = false)
    Long id;

}
