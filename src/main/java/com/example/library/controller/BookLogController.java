package com.example.library.controller;

import com.example.library.entity.BookLog;
import com.example.library.servise.BookLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class BookLogController {
    BookLogService bookLogService;
    @Autowired
    public BookLogController(BookLogService bookLogService) {
        this.bookLogService = bookLogService;
    }

    @GetMapping("library/get-logs/{userId}")
    public List<BookLog> getAllLogs(@PathVariable Long userId){
        return bookLogService.getLogs(userId);
    }
    @PostMapping("library/add-lease/")
    public void addLease(@RequestBody BookLog bookLog){
        bookLogService.addLog(bookLog);
    }
}

