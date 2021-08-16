package com.example.synergybackend.controller;
import com.example.synergybackend.model.OpenEnded;
import com.example.synergybackend.repository.OpenEndedRepository;
import com.example.synergybackend.services.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.synergybackend.model.OpenEnded;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class OpenEndedController {
    @Autowired
    private OpenEndedRepository openEndedRepository;
    @Autowired
    private SequenceService service;

    @GetMapping("/OpenEnded")
    public String getquestion(){
        return String.valueOf(openEndedRepository.findAll());
    }

    @PostMapping("/OpenEnded")
    public String saveQuestion(@RequestBody OpenEnded quest) {
        OpenEnded openEnded=new OpenEnded();
        openEnded.setId(service.getSequence(OpenEnded.SEQUENCE_NUMBER));
        openEnded.setQuestion( quest.getQuestion());
        openEndedRepository.save(openEnded);
        String url = "/OpenEnded/" + openEnded.getId();
        return url;
    }
    @GetMapping("/OpenEnded/{id}")
    public OpenEnded getOpenEndedquestion(@PathVariable("id") Long id){
        return (OpenEnded) openEndedRepository.findById(id).get();
    }
}
