package com.example.library.servise;

import com.example.library.entity.BookLog;
import com.example.library.repository.LogRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLogService {
    @PersistenceContext
    EntityManager entityManager;
    private final LogRepo logRepo;
    @Autowired
    public BookLogService(LogRepo logRepo) {
        this.logRepo = logRepo;
    }

    public List<BookLog> getLogs(Long userId){
        return logRepo.findByUserId(userId);
    }
    public void addLog(BookLog bookLog){
        logRepo.save(bookLog);
    }
}
