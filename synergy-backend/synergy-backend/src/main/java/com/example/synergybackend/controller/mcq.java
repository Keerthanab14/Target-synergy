package com.example.synergybackend.controller;

import com.example.synergybackend.model.Poll;
import com.example.synergybackend.model.User;
import com.example.synergybackend.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/create-poll")
@RestController
public class mcq {
    @Autowired
    private PollRepository pollRepository;
//    int a = 8900;
//    @PostMapping("/newPolls")
//    public String saveBook(@RequestBody Map<String, Object> user) {
//
//        Poll poll=new Poll();
//        poll.setId((long) a++);
//        poll.setQuestion(String.valueOf(user.get("question")));
//       // poll.setChoices();
//        pollRepository.save(poll);
//        System.out.println(user.get("question"));
//        return (String)user.get("data");
//    }
}
