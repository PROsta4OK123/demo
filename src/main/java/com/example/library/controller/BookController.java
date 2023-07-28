package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class BookController {
    private final BookRepo bookRepo;

    @Autowired
    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping(value = "library/get-book/{bookId}")
    public Optional<Book> getBook(@PathVariable Long bookId){
        return bookRepo.findById(bookId);
    }
    @PostMapping("library/add-book")
    public void addBook(@RequestParam String name, @RequestParam String createYear, @RequestParam String description){
        Book newBook = new Book(name, createYear,description);
        bookRepo.save(newBook);
    }
}
