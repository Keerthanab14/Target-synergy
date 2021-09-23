package com.example.synergybackend.controller;
import com.example.synergybackend.model.Background;
import com.example.synergybackend.model.OpenEnded;
import com.example.synergybackend.service.OpenEndedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class OpenEndedController {
    @Autowired
    private OpenEndedService openEndedService;

    //get by user
    @GetMapping("/{id}/OE")
    public List<OpenEnded> getByUser(@PathVariable("id") String id){
        return openEndedService.getByUser(id);
    }

    //get All
    @GetMapping("/OE")
    public List<OpenEnded> getAllquestion(){
            return openEndedService.getAllquestion();
        }

    //post OE
    @PostMapping("/OE")
    public String saveQuestion(@RequestBody OpenEnded quest) {
        return openEndedService.saveQuestion(quest);
    }

    //bg for OE
    @PutMapping("/OE/{id}/bg")
    public String saveWithBg(@PathVariable("id") String id,@RequestBody Background quest) {
        return openEndedService.saveWithBg(id, quest);
    }

    //get OE by ID
    @GetMapping("/OE/{id}")
    public OpenEnded getOpenEndedquestion(@PathVariable("id") String id){
        return openEndedService.getOpenEndedquestion(id);
    }

    //post WC
    @PostMapping("/WC")
    public String savewcQuestion(@RequestBody OpenEnded quest) {
        return openEndedService.savewcQuestion(quest);
    }

    //get WC by ID
    @GetMapping("/WC/{id}")
    public OpenEnded getWcQuestion(@PathVariable("id") String id){
        return openEndedService.getWcQuestion(id);
    }

    //bg for WC
    @PutMapping("/WC/{id}/bg")
    public String saveWCBg(@PathVariable("id") String id,@RequestBody Background quest) {
        return openEndedService.saveWCBg(id,quest);
    }

    //get QandA
    @GetMapping("/QandA")
    public List<OpenEnded> getAllQandA(){
        return openEndedService.getAllQandA();
    }

    //post QandA
    @PostMapping("/QandA")
    public String saveQandAQuestion(@RequestBody OpenEnded quest) {
        return openEndedService.saveQandAQuestion(quest);
    }

    //get QandA by ID
    @GetMapping("/QandA/{id}")
    public OpenEnded getQandAquestion(@PathVariable("id") String id){
        return openEndedService.getQandAquestion(id);
    }

    //bg for QandA
    @PutMapping("/QandA/{id}/bg")
    public String saveBg(@PathVariable("id") String id,@RequestBody Background quest) {
        return openEndedService.saveBg(id,quest);
    }
}
