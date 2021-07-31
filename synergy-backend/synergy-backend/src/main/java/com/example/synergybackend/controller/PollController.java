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
        poll.setId(service.getSequence(Poll.SEQUENCE_NUMBER));
        poll.setQuestion(String.valueOf(quest.getQuestion()));
        poll.setChoices( quest.getChoices());
        PollRepository.save(poll);
//        ArrayList<String> arr = new ArrayList<>();
//        arr = quest.get("choices");
//        quest.get("choices");
        System.out.println(quest);
        return "choices";
    }

//    @PostMapping
//    public String savePolls(@RequestBody Example example) {
//        Poll poll=new Poll();
//        poll.setId((long) a++);
//        poll.setQuestion(String.valueOf(quest.get("question")));
////        poll.setChoices(quest.get("choices"));
//        PollRepository.save(poll);
//        ArrayList<String> arr = new ArrayList<>();
//        arr = quest.get("choices");
//        quest.get("choices");
//        System.out.println(quest.get("choices").getClass());
//        return "choices";
//    }
}
