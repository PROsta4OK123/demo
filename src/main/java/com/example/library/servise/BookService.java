package com.example.library.servise;

import com.example.library.Exeption.ObjectNotFoundError;
import com.example.library.entity.Book;
import com.example.library.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void updateBook(Long id, String name, String createYear, String description) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundError("Book with this id not found"));
        setUpdateBook(book,name,createYear,description);
    }

    public void DeleteBook(Long id) {
        bookRepo.deleteById(id);
    }

    public Book getBook(Long id) {
        return bookRepo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundError("Book with this id not found"));
    }

    public void addBook(Book book) {
        bookRepo.save(book);
    }

    private void setUpdateBook(Book book, String name, String createYear, String description) {
        book.setName(name);
        book.setCreateYear(createYear);
        book.setDescription(description);
    }
}
