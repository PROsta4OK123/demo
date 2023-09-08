package com.example.library.servise;

import com.example.library.Exeption.ObjectNotFoundError;
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
        return userRepo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundError("User with this id not found"));
    }

    public void addUser(User user) {
        userRepo.save(user);
    }

    public void DeleteUser(Long id) {
        userRepo.deleteById(id);
    }

    public void UpdateUser(Long id, String name, String email, String phone){
        User user = userRepo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundError("User with this id not found"));
        setUserUpdate(user,name,email,phone);
    }
    private void setUserUpdate(User user,String name, String email, String phone){
        user.setEmail(email);
        user.setName(name);
        user.setPhone(phone);
    }
}
