package com.example.synergybackend.controller;

import com.example.synergybackend.model.Poll;
import com.example.synergybackend.repository.PollRepository;
import com.example.synergybackend.services.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/polls")
public class PollController {

    @Autowired
    private PollRepository PollRepository;
    @Autowired
    private SequenceService service;

    @GetMapping("/polls")
    public String getPoll(){
        return "polls";
    }
    @PostMapping("/newPoll")
    public String saveBook(@RequestBody Poll poll) {
        poll.setId(service.getSequence(Poll.SEQUENCE_NUMBER));
        PollRepository.save(poll);
        return "Added poll with id : " + poll.getId();
    }



}
