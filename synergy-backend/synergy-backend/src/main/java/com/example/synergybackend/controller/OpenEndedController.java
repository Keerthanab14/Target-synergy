package com.example.synergybackend.controller;
import com.example.synergybackend.model.Background;
import com.example.synergybackend.model.OpenEnded;
import com.example.synergybackend.repository.OpenEndedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class OpenEndedController {
    @Autowired
    private OpenEndedRepository openEndedRepository;

    //get by user
    @GetMapping("/{id}/OE")
    public List<OpenEnded> getByUser(@PathVariable("id") String id){
        return openEndedRepository.findAllByGoogleId(id);
    }

    //get All
    @GetMapping("/OE")
    public List<OpenEnded> getAllquestion(){
            return openEndedRepository.findAll();
        }

    //post OE
    @PostMapping("/OE")
    public String saveQuestion(@RequestBody OpenEnded quest) {
        OpenEnded openEnded=new OpenEnded();
        openEnded.setQuestion( quest.getQuestion());
        openEnded.setGoogleId((quest.getGoogleId()));
        openEnded.setType(quest.getType());
        OpenEnded saved= openEndedRepository.save(openEnded);
        String url = "OE/" + saved.getId();
        return url;
    }

    //bg for OE
    @PutMapping("/OE/{id}/bg")
    public String saveWithBg(@PathVariable("id") String id,@RequestBody Background quest) {
        OpenEnded OE=openEndedRepository.findById(id).get();
        OE.setBg(quest);
        OpenEnded savedPoll = openEndedRepository.save(OE);
        String url = "OE/" + savedPoll.getId();
        return url;
    }

    //get OE by ID
    @GetMapping("/OE/{id}")
    public OpenEnded getOpenEndedquestion(@PathVariable("id") String id){
        return openEndedRepository.findById(id).get();
    }

    //post WC
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

    //get WC by ID
    @GetMapping("/WC/{id}")
    public OpenEnded getWcQuestion(@PathVariable("id") String id){
        return openEndedRepository.findById(id).get();
    }

    //bg for WC
    @PutMapping("/WC/{id}/bg")
    public String saveWCBg(@PathVariable("id") String id,@RequestBody Background quest) {
        OpenEnded OE=openEndedRepository.findById(id).get();
        OE.setBg(quest);
        OpenEnded savedPoll = openEndedRepository.save(OE);
        String url = "WC/" + savedPoll.getId();
        return url;
    }

    //get QandA
    @GetMapping("/QandA")
    public List<OpenEnded> getAllQandA(){
        return openEndedRepository.findAll();
    }

    //post QandA
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

    //get QandA by ID
    @GetMapping("/QandA/{id}")
    public OpenEnded getQandAquestion(@PathVariable("id") String id){
        return openEndedRepository.findById(id).get();
    }

    //bg for QandA
    @PutMapping("/QandA/{id}/bg")
    public String saveBg(@PathVariable("id") String id,@RequestBody Background quest) {
        OpenEnded OE=openEndedRepository.findById(id).get();
        OE.setBg(quest);
        OpenEnded savedPoll = openEndedRepository.save(OE);
        String url = "QandA/" + savedPoll.getId();
        return url;
    }
}
