package com.example.synergybackend.controller;

import com.example.synergybackend.model.Poll;
import com.example.synergybackend.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api/polls")
public class PollController {

    @Autowired
    private PollRepository PollRepository;
//    @Autowired
//    private SequenceService service;

    @GetMapping("/polls")
    public List<Poll> getPolls(){
        return PollRepository.findAll();
    }
    @GetMapping("/polls/{id}")
    public Optional<Poll> getPollById(@PathVariable("id") Long id){
        return PollRepository.findById(id);
    }
    @PostMapping("/newPoll")
    public String saveBook(@RequestBody Poll poll) {
//        poll.setId(service.getSequence(Poll.SEQUENCE_NUMBER));
        PollRepository.save(poll);
        return "Added poll with id : " + poll.getId();
    }



}
