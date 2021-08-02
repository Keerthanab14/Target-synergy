package com.example.synergybackend.controller;

import com.example.synergybackend.model.Choice;
import com.example.synergybackend.model.Poll;
import com.example.synergybackend.repository.PollRepository;
import com.example.synergybackend.services.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class PollController {

    @Autowired
    private PollRepository PollRepository;
    @Autowired
    private SequenceService service;

    @GetMapping("/polls")
    public List<Poll> getPolls(){
        return PollRepository.findAll();
    }
    @GetMapping("/polls/{id}")
    public Poll getPollById(@PathVariable("id") Long id){
        return PollRepository.findById(id).get();
    }

    @PostMapping("/polls")
    public String savePolls(@RequestBody Poll quest) {
        Poll poll=new Poll();
        poll.setQuestion(String.valueOf(quest.getQuestion()));
        poll.setChoices( quest.getChoices());
        Poll savedPoll = PollRepository.save(poll);
        String url = "http://localhost:8080/polls/"+ savedPoll.getId();
        return url;
    }

}
