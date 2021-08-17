package com.example.synergybackend.controller;
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
   /* @Autowired
    private SequenceService service;*/

    @GetMapping("/OpenEnded")
    public List<OpenEnded> getAllquestion(){

            return openEndedRepository.findAll();
        }

    @PostMapping("/OpenEnded")
    public String saveQuestion(@RequestBody OpenEnded quest) {
        OpenEnded openEnded=new OpenEnded();
       // openEnded.setId(service.getSequence(OpenEnded.SEQUENCE_NUMBER));
        openEnded.setQuestion( quest.getQuestion());
        OpenEnded saved= openEndedRepository.save(openEnded);
        String url = "/OpenEnded/" + saved.getId();
        return url;
    }
    @GetMapping("/OpenEnded/{id}")
    public OpenEnded getOpenEndedquestion(@PathVariable("id") String id){
        return openEndedRepository.findById(id).get();
    }
}
