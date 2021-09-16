package com.example.synergybackend.controller;


import com.example.synergybackend.model.Mcq;
import com.example.synergybackend.repository.MCQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.synergybackend.model.Background;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class McqController {
    @Autowired
    private MCQRepository mcqRepo;

    //get mcq by user id
    @GetMapping("/{id}/MCQ")
    public List<Mcq> getMcqByUser(@PathVariable("id") String id){
        return mcqRepo.findAllByGoogleId(id);
    }

    //get mcq by id
    @GetMapping("/MCQ/{id}")
    public Mcq getMcqById(@PathVariable("id") String id){
        return mcqRepo.findById(id).get();
    }

    //get all mcq
    @GetMapping("/MCQ")
    public List<Mcq> getAllMcq(){
        return mcqRepo.findAll();
    }

    //post mcq
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

    //bg for mcq
    @PutMapping("/MCQ/{id}/bg")
    public String saveWithBg(@PathVariable("id") String id,@RequestBody Background quest) {
        Mcq mcq=mcqRepo.findById(id).get();
        mcq.setBg(quest);
        Mcq savedPoll = mcqRepo.save(mcq);
        String url = "MCQ/" + savedPoll.getId();
        return url;
    }

    //update votes
    @PutMapping("/MCQ/{id}")
    public Mcq updateMcq(@PathVariable("id") String id,@RequestBody Mcq quest) {
        Mcq mcq=mcqRepo.findById(id).get();
        mcq.setChoices(quest.getChoices());
        Mcq savedPoll = mcqRepo.save(mcq);
        return savedPoll;
    }

    //****SCALES****
    //post scales
    @PostMapping("/SC")
    public String saveSC(@RequestBody Mcq quest) {
        Mcq mcq=new Mcq();
        mcq.setQuestion(String.valueOf(quest.getQuestion()));
        mcq.setChoices( quest.getChoices());
        mcq.setGoogleId(quest.getGoogleId());
        Mcq savedPoll = mcqRepo.save(mcq);
        String url = "SC/" + savedPoll.getId();
        return url;
    }

    //responses for scales
    @PutMapping("/SC/{id}")
    public Mcq updateSC(@PathVariable("id") String id,@RequestBody Mcq quest) {
        Mcq mcq=mcqRepo.findById(id).get();
        mcq.setChoices(quest.getChoices());
        Mcq savedPoll = mcqRepo.save(mcq);
        return savedPoll;
    }

    //bg for scales
    @PutMapping("/SC/{id}/bg")
    public String saveWithB(@PathVariable("id") String id,@RequestBody Background quest) {
        Mcq mcq=mcqRepo.findById(id).get();

        mcq.setBg(quest);

        Mcq savedPoll = mcqRepo.save(mcq);
        String url = "SC/" + savedPoll.getId();
        return url;
    }

    //get scales by id
    @GetMapping("/SC/{id}")
    public Mcq getSC(@PathVariable("id") String id){
        return mcqRepo.findById(id).get();
    }


    //****RATING****

    //post rating question
    @PostMapping("/RT")
    public String saveRT(@RequestBody Mcq quest) {
        Mcq mcq=new Mcq();
        mcq.setQuestion(String.valueOf(quest.getQuestion()));
        mcq.setChoices( quest.getChoices());
        mcq.setGoogleId(quest.getGoogleId());
        Mcq savedPoll = mcqRepo.save(mcq);
        String url = "RT/" + savedPoll.getId();
        return url;
    }

    //response for rating
    @PutMapping("/RT/{id}")
    public Mcq updateRT(@PathVariable("id") String id,@RequestBody Mcq quest) {
        Mcq mcq=mcqRepo.findById(id).get();
        mcq.setChoices(quest.getChoices());
        Mcq savedPoll = mcqRepo.save(mcq);
        return savedPoll;
    }

    //bg for rating
    @PutMapping("/RT/{id}/bg")
    public String saveBg(@PathVariable("id") String id,@RequestBody Background quest) {
        Mcq mcq=mcqRepo.findById(id).get();
        mcq.setBg(quest);
        Mcq savedPoll = mcqRepo.save(mcq);
        String url = "RT/" + savedPoll.getId();
        return url;
    }

    //get rating by id
    @GetMapping("/RT/{id}")
    public Mcq getRT(@PathVariable("id") String id){
        return mcqRepo.findById(id).get();
    }

}
