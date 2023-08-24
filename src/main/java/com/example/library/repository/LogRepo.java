package com.example.library.repository;

import com.example.library.entity.BookLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepo extends JpaRepository<BookLog,Long> {
}
