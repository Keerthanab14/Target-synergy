package com.example.synergybackend.controller;


import com.example.synergybackend.model.Responses;
import com.example.synergybackend.repository.ResponsesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ResponsesController {
    @Autowired
    private ResponsesRepository responsesRepository;

    @GetMapping("/responses")
    public List<Responses> getAllResponses() {
        return responsesRepository.findAll();
    }

    @GetMapping("/responses/{id}")
    public Responses getResponsesById(@PathVariable("id") String id) {
        return responsesRepository.findById(id).get();
    }

    @PutMapping("/responses/{id}")
    public String saveResponses(@RequestBody Responses quest, @PathVariable("id") String id) {
        try
        {
            responsesRepository.findById(id).get();
            Responses responses = responsesRepository.findById(id).get();
            Responses resp = new Responses();
            responses.setLatestAnswer(quest.getLatestAnswer());
            responses.setResponses(responses.getResponses());
            Responses savedResponse = responsesRepository.save(responses);
            String url = "/responses/" + savedResponse.getId();
            return url;

        } catch (Exception e) {
            return saveNewResponses(quest);
        }
    }

    @PostMapping("/responses")
    public String saveNewResponses(@RequestBody Responses quest) {
        Responses responses = new Responses();
        responses.setLatestAnswer(quest.getLatestAnswer());
        responses.setResponses(quest.getResponses());
        Responses savedResponse = responsesRepository.save(responses);
        String url = "/responses/" + savedResponse.getId();
        return url;

    }
}
