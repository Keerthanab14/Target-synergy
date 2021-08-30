package com.example.synergybackend.controller;


import com.example.synergybackend.model.Choice;
import com.example.synergybackend.model.Mcq;
import com.example.synergybackend.repository.MCQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        System.out.println(quest.getChoices());
        Mcq mcq=new Mcq();
        mcq.setQuestion(String.valueOf(quest.getQuestion()));
        mcq.setChoices( quest.getChoices());
        mcq.setGoogleId(quest.getGoogleId());
        mcq.setBgcolor(quest.getBgcolor());
        mcq.setTextcolor(quest.getTextcolor());
        mcq.setOpacity(quest.getOpacity());
        mcq.setBgimagekey(quest.getBgimagekey());
//       System.out.println(mcq.getChoices());

        Mcq savedPoll = mcqRepo.save(mcq);
        String url = "MCQ/" + savedPoll.getId();
        return url;
    }
    @PutMapping("/MCQ/{id}")
    public Mcq updateMcq(@PathVariable("id") String id,@RequestBody Mcq quest) {
        Mcq mcq=mcqRepo.findById(id).get();
//        System.out.println(mcq.getChoices());
        mcq.setChoices(quest.getChoices());
        System.out.println(mcq.getChoices());
        Mcq savedPoll = mcqRepo.save(mcq);
        return savedPoll;
    }

    //scales
    @PostMapping("/SC")
    public String saveSC(@RequestBody Mcq quest) {
        System.out.println(quest.getChoices());
        Mcq mcq=new Mcq();
        mcq.setQuestion(String.valueOf(quest.getQuestion()));
        mcq.setChoices( quest.getChoices());
        mcq.setGoogleId(quest.getGoogleId());
//        System.out.println(mcq.getChoices());
        Mcq savedPoll = mcqRepo.save(mcq);
        String url = "SC/" + savedPoll.getId();
        return url;
    }
    @PutMapping("/SC/{id}")
    public Mcq updateSC(@PathVariable("id") String id,@RequestBody Mcq quest) {
        Mcq mcq=mcqRepo.findById(id).get();
//        System.out.println(mcq.getChoices());
        mcq.setChoices(quest.getChoices());
        System.out.println(mcq.getChoices());
        Mcq savedPoll = mcqRepo.save(mcq);
        return savedPoll;
    }

    @GetMapping("/SC/{id}")
    public Mcq getSC(@PathVariable("id") String id){
        return mcqRepo.findById(id).get();
    }

    //rating
    @PostMapping("/RT")
    public String saveRT(@RequestBody Mcq quest) {
        System.out.println(quest.getChoices());
        Mcq mcq=new Mcq();
        mcq.setQuestion(String.valueOf(quest.getQuestion()));
        mcq.setChoices( quest.getChoices());
        mcq.setGoogleId(quest.getGoogleId());
//        System.out.println(mcq.getChoices());
        Mcq savedPoll = mcqRepo.save(mcq);
        String url = "RT/" + savedPoll.getId();
        return url;
    }
    @PutMapping("/RT/{id}")
    public Mcq updateRT(@PathVariable("id") String id,@RequestBody Mcq quest) {
        Mcq mcq=mcqRepo.findById(id).get();
//        System.out.println(mcq.getChoices());
        mcq.setChoices(quest.getChoices());
        System.out.println(mcq.getChoices());
        Mcq savedPoll = mcqRepo.save(mcq);
        return savedPoll;
    }

    @GetMapping("/RT/{id}")
    public Mcq getRT(@PathVariable("id") String id){
        return mcqRepo.findById(id).get();
    }

}
