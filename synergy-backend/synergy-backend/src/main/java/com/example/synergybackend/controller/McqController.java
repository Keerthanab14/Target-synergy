package com.example.synergybackend.controller;


import com.example.synergybackend.model.Mcq;
<<<<<<< HEAD
import com.example.synergybackend.repository.*;
=======
import com.example.synergybackend.model.Responses;
import com.example.synergybackend.repository.MCQRepository;
>>>>>>> 5048b93294c2074950f7ed36b18fd1e5c240a372
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;
=======
>>>>>>> 5048b93294c2074950f7ed36b18fd1e5c240a372
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public abstract class McqController {
    @Autowired
    private MCQRepository mcqRepo;

    @GetMapping("/{id}/MCQ")
    public List<Mcq> getMcqByUser(@PathVariable("id") String id){
        return mcqRepo.findAllByGoogleId(id);
    }

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
        mcq.setType((quest.getType()));
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
