package com.example.synergybackend.controller;

import com.example.synergybackend.model.User;
import com.example.synergybackend.repository.UserRepository;
import com.example.synergybackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //get all user
    @GetMapping("/user")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    //get user by ID
    @GetMapping("/user/{googleId}")
    public User getUser(@PathVariable("googleId") String googleId){
        return userService.getUser(googleId);
    }

    //post new User
    @PostMapping("/user")
    public String saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }



}
