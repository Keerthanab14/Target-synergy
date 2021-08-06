package com.example.synergybackend.controller;


import com.example.synergybackend.model.User;
import com.example.synergybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/newUser")
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
