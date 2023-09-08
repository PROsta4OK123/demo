package com.example.library.repository;

import com.example.library.entity.BookLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepo extends JpaRepository<BookLog,Long> {
    List<BookLog> findByUserId(Long userId);
}
