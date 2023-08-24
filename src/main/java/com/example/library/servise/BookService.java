package com.example.library.servise;

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

    public boolean updateBook(Long id, String name, String createYear, String description) {
        boolean isPresent= bookRepo.findById(id).isPresent();
        if(isPresent){
            Book book = bookRepo.findById(id).get();
            book.setName(name);
            book.setCreateYear(createYear);
            book.setDescription(description);
            return true;
        }else{
            System.out.println("Not found");
        }return false;
    }

    public void DeleteBook(Long id) {
        bookRepo.deleteById(id);
    }
    public Book getBook(Long id){
        boolean isPresent= bookRepo.findById(id).isPresent();
        if(isPresent){
            return bookRepo.findById(id).get();
        }else {
            System.out.println("Not found");
            return null;
        }
    }
    public void addBook(Book book){
        bookRepo.save(book);
    }
}
