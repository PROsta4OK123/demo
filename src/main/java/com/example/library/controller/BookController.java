package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @GetMapping(value = "library/get-book/{bookId}")
    public Book getBook(@PathVariable long bookId){
        return bookRepository.findById(bookId);
    }
    @PostMapping("library/add-book")
    public void addBook(@RequestParam String name, @RequestParam String createYear, @RequestParam String description){
        Book newBook = new Book(name, createYear,description);
        bookRepository.save(newBook);
    }
}
