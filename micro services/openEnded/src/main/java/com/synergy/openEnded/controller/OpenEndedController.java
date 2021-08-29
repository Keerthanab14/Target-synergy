package com.synergy.openEnded.controller;

import com.synergy.openEnded.model.OpenEnded;
import com.synergy.openEnded.repository.OpenEndedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class OpenEndedController {
    @Autowired
    private OpenEndedRepository openEndedRepository;

    @GetMapping("/OE")
    public List<OpenEnded> getAllquestion(){
        return openEndedRepository.findAll();
    }

    @PostMapping("/OE")
    public String saveQuestion(@RequestBody OpenEnded quest) {
        OpenEnded openEnded=new OpenEnded();
        openEnded.setQuestion( quest.getQuestion());
        OpenEnded saved= openEndedRepository.save(openEnded);
        String url = "OE/" + saved.getId();
        return url;
    }
    @GetMapping("/OE/{id}")
    public OpenEnded getOpenEndedquestion(@PathVariable("id") String id){
        return openEndedRepository.findById(id).get();
    }
    @PostMapping("/WC")
    public String savewcQuestion(@RequestBody OpenEnded quest) {
        OpenEnded openEnded=new OpenEnded();
        // openEnded.setId(service.getSequence(OpenEnded.SEQUENCE_NUMBER));
        openEnded.setQuestion( quest.getQuestion());
        OpenEnded saved= openEndedRepository.save(openEnded);
        String url = "WC/" + saved.getId();
        return url;
    }
    @GetMapping("/WC/{id}")
    public OpenEnded getWcQuestion(@PathVariable("id") String id){
        return openEndedRepository.findById(id).get();
    }


    @GetMapping("/QandA")
    public List<OpenEnded> getAllQandA(){
        return openEndedRepository.findAll();
    }
    @PostMapping("/QandA")
    public String saveQandAQuestion(@RequestBody OpenEnded quest) {
        OpenEnded openEnded=new OpenEnded();
        openEnded.setQuestion( quest.getQuestion());
        OpenEnded saved= openEndedRepository.save(openEnded);
        String url = "QandA/" + saved.getId();
        return url;
    }
    @GetMapping("/QandA/{id}")
    public OpenEnded getQandAquestion(@PathVariable("id") String id){
        return openEndedRepository.findById(id).get();
    }
}
