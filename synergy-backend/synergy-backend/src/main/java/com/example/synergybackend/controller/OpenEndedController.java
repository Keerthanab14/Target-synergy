package com.example.synergybackend.controller;
import com.example.synergybackend.model.Background;
import com.example.synergybackend.model.Mcq;
import com.example.synergybackend.model.OpenEnded;
import com.example.synergybackend.repository.OpenEndedRepository;
import com.example.synergybackend.services.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.synergybackend.model.OpenEnded;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class OpenEndedController {
    @Autowired
    private OpenEndedRepository openEndedRepository;

    @GetMapping("/{id}/OE")
    public List<OpenEnded> getMcqByUser(@PathVariable("id") String id){
        return openEndedRepository.findAllByGoogleId(id);
    }

    @GetMapping("/OE")
    public List<OpenEnded> getAllquestion(){
            return openEndedRepository.findAll();
        }

    @PostMapping("/OE")
    public String saveQuestion(@RequestBody OpenEnded quest) {
        System.out.println(quest.getGoogleId());
        OpenEnded openEnded=new OpenEnded();
        openEnded.setQuestion( quest.getQuestion());
        openEnded.setGoogleId((quest.getGoogleId()));
        openEnded.setType(quest.getType());
        OpenEnded saved= openEndedRepository.save(openEnded);
        String url = "OE/" + saved.getId();
        return url;
    }
    @PutMapping("/OE/{id}/bg")
    public String saveWithBg(@PathVariable("id") String id,@RequestBody Background quest) {
        OpenEnded OE=openEndedRepository.findById(id).get();
        OE.setBg(quest);
        OpenEnded savedPoll = openEndedRepository.save(OE);
        String url = "OE/" + savedPoll.getId();
        return url;
    }
    @GetMapping("/OE/{id}")
    public OpenEnded getOpenEndedquestion(@PathVariable("id") String id){
        return openEndedRepository.findById(id).get();
    }
    @PostMapping("/WC")
    public String savewcQuestion(@RequestBody OpenEnded quest) {
        OpenEnded openEnded=new OpenEnded();
        openEnded.setGoogleId((quest.getGoogleId()));
        openEnded.setQuestion( quest.getQuestion());
        openEnded.setType(quest.getType());
        OpenEnded saved= openEndedRepository.save(openEnded);
        String url = "WC/" + saved.getId();
        return url;
    }
    @GetMapping("/WC/{id}")
    public OpenEnded getWcQuestion(@PathVariable("id") String id){
        return openEndedRepository.findById(id).get();
    }
    @PutMapping("/WC/{id}/bg")
    public String saveWCBg(@PathVariable("id") String id,@RequestBody Background quest) {
        OpenEnded OE=openEndedRepository.findById(id).get();
        OE.setBg(quest);
        OpenEnded savedPoll = openEndedRepository.save(OE);
        String url = "WC/" + savedPoll.getId();
        return url;
    }

    @GetMapping("/QandA")
    public List<OpenEnded> getAllQandA(){
        return openEndedRepository.findAll();
    }
    @PostMapping("/QandA")
    public String saveQandAQuestion(@RequestBody OpenEnded quest) {
        OpenEnded openEnded=new OpenEnded();
        openEnded.setQuestion( quest.getQuestion());
        openEnded.setGoogleId((quest.getGoogleId()));
        openEnded.setType(quest.getType());
        OpenEnded saved= openEndedRepository.save(openEnded);
        String url = "QandA/" + saved.getId();
        return url;
    }
    @GetMapping("/QandA/{id}")
    public OpenEnded getQandAquestion(@PathVariable("id") String id){
        return openEndedRepository.findById(id).get();
    }
    @PutMapping("/QandA/{id}/bg")
    public String saveBg(@PathVariable("id") String id,@RequestBody Background quest) {
        OpenEnded OE=openEndedRepository.findById(id).get();
        OE.setBg(quest);
        OpenEnded savedPoll = openEndedRepository.save(OE);
        String url = "QandA/" + savedPoll.getId();
        return url;
    }
}
