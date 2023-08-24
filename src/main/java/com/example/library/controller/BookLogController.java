package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.entity.BookLog;
import com.example.library.repository.BookRepo;
import com.example.library.repository.LogRepo;
import com.example.library.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class BookLogController {

    private final UserRepo userRepo;
    private final BookRepo bookRepo;
    private final LogRepo logRepo;
    @Autowired
    public BookLogController(UserRepo userRepo, BookRepo bookRepo, LogRepo logRepo) {
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
        this.logRepo = logRepo;
    }

    @GetMapping
    public List<BookLog> getAllLogs(@RequestBody GetRequest request){
        return logRepo.findAllById(request.getId());
    }
    @PostMapping
    public void addLease(@RequestBody CreateRequest createRequest){
        Optional<Book> book = bookRepo.findById(createRequest.bookId);
        BookLog bookLog = new BookLog();
        bookLog.setBookName(book.get().getName());
        bookLog.setUserId(createRequest.userID);
        bookLog.setOnLease(true);
        logRepo.save(bookLog);
    }
    private static class CreateRequest{
        private Long userID;
        private Long bookId;
    }
    private static class GetRequest{
        public Iterable<Long> getId() {
            return id;
        }

        private Iterable<Long> id;
    }
}

