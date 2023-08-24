package com.example.library.controller;

import com.example.library.entity.User;
import com.example.library.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("library/get-user/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }
    @PostMapping("library/add-user/")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
    @DeleteMapping("library/delete-user/{id}")
    public void removeUser(@PathVariable Long id){
        userService.DeleteUser(id);
    }
    @PatchMapping("library/get-user/{id}")
    public void updateUser(@PathVariable Long id,@RequestParam String name, @RequestParam String email, @RequestParam String phone){
        userService.UpdateUser(id, name, email, phone);
    }



}
