package com.example.synergybackend.controller;

import com.example.synergybackend.model.User;
import com.example.synergybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    @GetMapping("/user/{googleId}")
    public User getUser(@PathVariable("googleId") String googleId){
        return userRepository.findByGoogleId(googleId);
    }
    @PostMapping("/user")
    public String saveBook(@RequestBody Map<String, Object> user) {
        User userr = new User();
        userr.setEmail(String.valueOf(user.get("email")));
        userr.setGoogleId(String.valueOf(user.get("googleId")));
        userr.setName(String.valueOf(user.get("name")));
        userRepository.save(userr);
        System.out.println(user.get("googleId"));
        return (String)user.get("data");
    }



}
