package com.example.synergybackend.controller;


import com.example.synergybackend.model.Mcq;
import com.example.synergybackend.repository.MCQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class McqController {
    @Autowired
    private MCQRepository mcqRepo;

    @GetMapping("/MCQ")
    public List<Mcq> getAllMcq(){
        return mcqRepo.findAll();
    }
    @GetMapping("/MCQ/{id}")
    public Mcq getMcqById(@PathVariable("id") String id){
        return mcqRepo.findById(id).get();
    }

    @PostMapping("/MCQ")
    public String saveMcq(@RequestBody Mcq quest) {
        Mcq mcq=new Mcq();
        mcq.setQuestion(String.valueOf(quest.getQuestion()));
        mcq.setChoices( quest.getChoices());
        mcq.setGoogleId(quest.getGoogleId());
        Mcq savedPoll = mcqRepo.save(mcq);
        String url = "/MCQ/" + savedPoll.getId();
        return url;
    }
}
