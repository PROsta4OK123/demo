package com.example.library.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class BookLog {
    public BookLog() {
    }

    public BookLog(Long userId, Long bookId, boolean onLease) {
        this.userId = userId;
        this.bookId = bookId;
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
    Long bookId;
    @Column(nullable = false)
    boolean onLease;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isOnLease() {
        return onLease;
    }

    public void setOnLease(boolean onLease) {
        this.onLease = onLease;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
