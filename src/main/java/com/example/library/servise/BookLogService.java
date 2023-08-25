package com.example.library.servise;

import com.example.library.entity.BookLog;
import com.example.library.repository.BookRepo;
import com.example.library.repository.LogRepo;
import com.example.library.repository.UserRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<BookLog> GetLogs(Long userId){
        TypedQuery<BookLog> query = entityManager.createQuery(
                "Select e From BookLog e where e.userId =?1", BookLog.class
        );
        return query.setParameter(1,userId.toString()).getResultList();
    }
    public void addLog(BookLog bookLog){
        logRepo.save(bookLog);
    }
}
