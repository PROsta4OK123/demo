package com.example.library.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table
public class BookLog {
    public BookLog() {
    }

    public BookLog(Long userId, String bookName, boolean onLease) {
        this.userId = userId;
        this.bookName = bookName;
        this.onLease = onLease;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 255, nullable = false)
    Long id;

    @Column(nullable = false, length = 255)
    Long userId;

    @Column(nullable = false)
    String bookName;
    @Column(nullable = false)
    boolean onLease;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isOnLease() {
        return onLease;
    }

    public void setOnLease(boolean onLease) {
        this.onLease = onLease;
    }
}
