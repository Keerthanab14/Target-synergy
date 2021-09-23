package com.example.synergybackend.service;

import com.example.synergybackend.model.User;
import com.example.synergybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    //get user by ID

    public User getUser(@PathVariable("googleId") String googleId){
        return userRepository.findByGoogleId(googleId);
    }

    //post new User

    public String saveUser(@RequestBody User user) {
        User userr = new User();
        userr.setEmail(String.valueOf(user.getEmail()));
        userr.setGoogleId(String.valueOf(user.getGoogleId()));
        userr.setName(String.valueOf(user.getName()));
        userRepository.save( userr);
        return "new user saved";
    }
}
