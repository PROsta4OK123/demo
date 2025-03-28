package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.servise.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Optional;


@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("library/get-book/{bookId}")
    public Book getBook(@PathVariable Long bookId) {
        return bookService.getBook(bookId);
    }
    @PostMapping("library/add-book")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @DeleteMapping("library/remove/{id}")
    public void removeBook(@PathVariable Long id) {
        bookService.DeleteBook(id);
    }

    @PatchMapping("library/update/{id}")
    public void updateBook(@PathVariable Long id, @RequestParam String name, @RequestParam String createYear, @RequestParam String description) {
        bookService.updateBook(id, name, createYear, description);
    }
}
