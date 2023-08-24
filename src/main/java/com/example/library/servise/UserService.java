package com.example.library.servise;

import com.example.library.entity.User;
import com.example.library.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User getUser(Long id) {
        boolean isPresent = userRepo.findById(id).isPresent();
        if (isPresent) {
            return userRepo.findById(id).get();
        } else {
            System.out.println("Not found");
            return null;
        }
    }

    public void addUser(User user) {
        userRepo.save(user);
    }

    public void DeleteUser(Long id) {
        userRepo.deleteById(id);
    }

    public void UpdateUser(Long id, String name, String email, String phone){
        boolean isPresent = userRepo.findById(id).isPresent();
        if(isPresent){
            User user = userRepo.findById(id).get();
            user.setEmail(email);
            user.setName(name);
            user.setPhone(phone);
        }else System.out.println("User not found");
    }
}
