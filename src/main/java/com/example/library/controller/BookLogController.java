package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.entity.BookLog;
import com.example.library.repository.BookRepo;
import com.example.library.repository.LogRepo;
import com.example.library.repository.UserRepo;
import com.example.library.servise.BookLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public class BookLogController {
    @Autowired
    BookLogService bookLogService;
    @GetMapping("library/get-log/")
    public List<BookLog> getAllLogs(@RequestParam Long userId){
        return bookLogService.GetLogs(userId);
    }
    @PostMapping
    public void addLease(@RequestBody BookLog bookLog){
        bookLogService.addLog(bookLog);
    }
}

