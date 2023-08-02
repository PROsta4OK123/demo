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
    public void addBook(@RequestBody Book book) {
        bookRepo.save(book);
    }
    @DeleteMapping("library/remove")
    public void removeBook(@RequestBody DeleteRequest request){
        bookRepo.deleteById(request.getId());
    }
    @PatchMapping("library/update/name")
    public void updateBook(@RequestBody UpdateRequest request){
        Book book = bookRepo.getById(request.getId());
        updateName(request.getName(),book);
        updateDescription(request.getDescription(),book);
        updateYear(request.getCreateYear(),book);
        bookRepo.save(book);
    }
    private void updateName(String name, Book book){
        if(name != null){
            book.setName(name);
        }
    }
    private void updateDescription(String description, Book book){
        if(description != null){
            book.setDescription(description);
        }
    }
    private void updateYear(String year, Book book){
        if(year != null){
            book.setCreateYear(year);
        }
    }
    public static class DeleteRequest{
        private Long id;
        public Long getId() {
            return id;
        }
    }
    public static class UpdateRequest{
        private Long id;
        private  String name;
        private String createYear;
        private String Description;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCreateYear() {
            return createYear;
        }

        public void setCreateYear(String createYear) {
            this.createYear = createYear;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            Description = description;
        }
        public Long getId() {
            return id;
        }
    }


}
