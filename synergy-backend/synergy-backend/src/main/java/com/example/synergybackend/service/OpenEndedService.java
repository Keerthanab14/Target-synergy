package com.example.synergybackend.service;

import com.example.synergybackend.model.Background;
import com.example.synergybackend.model.OpenEnded;
import com.example.synergybackend.repository.OpenEndedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
public class OpenEndedService {
    @Autowired
    private OpenEndedRepository openEndedRepository;

    //get by user

    public List<OpenEnded> getByUser(@PathVariable("id") String id){
        return openEndedRepository.findAllByGoogleId(id);
    }

    //get All

    public List<OpenEnded> getAllquestion(){
        return openEndedRepository.findAll();
    }

    //post OE

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

    public String saveWithBg(@PathVariable("id") String id,@RequestBody Background quest) {
        OpenEnded OE=openEndedRepository.findById(id).get();
        OE.setBg(quest);
        OpenEnded savedPoll = openEndedRepository.save(OE);
        String url = "OE/" + savedPoll.getId();
        return url;
    }

    //get OE by ID

    public OpenEnded getOpenEndedquestion(@PathVariable("id") String id){
        return openEndedRepository.findById(id).get();
    }

    //post WC

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

    public OpenEnded getWcQuestion(@PathVariable("id") String id){
        return openEndedRepository.findById(id).get();
    }

    //bg for WC
    public String saveWCBg(@PathVariable("id") String id,@RequestBody Background quest) {
        OpenEnded OE=openEndedRepository.findById(id).get();
        OE.setBg(quest);
        OpenEnded savedPoll = openEndedRepository.save(OE);
        String url = "WC/" + savedPoll.getId();
        return url;
    }

    //get QandA

    public List<OpenEnded> getAllQandA(){
        return openEndedRepository.findAll();
    }

    //post QandA

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

    public OpenEnded getQandAquestion(@PathVariable("id") String id){
        return openEndedRepository.findById(id).get();
    }

    //bg for QandA

    public String saveBg(@PathVariable("id") String id,@RequestBody Background quest) {
        OpenEnded OE=openEndedRepository.findById(id).get();
        OE.setBg(quest);
        OpenEnded savedPoll = openEndedRepository.save(OE);
        String url = "QandA/" + savedPoll.getId();
        return url;
    }
}
