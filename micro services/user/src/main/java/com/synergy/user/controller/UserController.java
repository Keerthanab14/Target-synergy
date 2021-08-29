package com.synergy.user.controller;

import com.synergy.user.model.User;
import com.synergy.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable("id") String id){
        return userRepository.findById(id);
    }
    @PostMapping("/user")
    public String saveUser(@RequestBody Map<String, Object> user) {
        User userr = new User();
        userr.setEmail(String.valueOf(user.get("email")));
        userr.setGoogleId(String.valueOf(user.get("googleId")));
        userr.setName(String.valueOf(user.get("name")));
        userRepository.save(userr);
        System.out.println(user.get("googleId"));
        return (String)user.get("data");
    }

}
