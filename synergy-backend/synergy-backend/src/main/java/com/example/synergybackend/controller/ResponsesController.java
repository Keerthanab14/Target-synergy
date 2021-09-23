package com.example.synergybackend.controller;

import com.example.synergybackend.model.Responses;
import com.example.synergybackend.repository.ResponsesRepository;
import com.example.synergybackend.service.ResponsesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ResponsesController {
    @Autowired
    private ResponsesService responsesService;

    //get responses
    @GetMapping("/responses")
    public List<Responses> getAllResponses() {
        return responsesService.getAllResponses();
    }

    //get responses by ID
    @GetMapping("/responses/{id}")
    public Responses getResponsesById(@PathVariable("id") String id) {
        return responsesService.getResponsesById(id);
    }

    //get by Question ID
    @GetMapping("/quest/{id}")
    public String getQuestionById(@PathVariable("id") String id){
         return responsesService.getQuestionById(id);
    }


    //post response
    @PostMapping("/responses")
    public String saveNewResponses(@RequestBody Responses quest) {
        return responsesService.saveNewResponses(quest);

    }


    //add responses
    @PutMapping("/responses/{id}")
    public String saveResponses(@RequestBody Responses quest, @PathVariable("id") String id) {
        try
        {
            return responsesService.saveResponses(quest, id);

        } catch (Exception e) {
            return responsesService.saveNewResponses(quest);
        }
    }


    //get Wc response
    @GetMapping("/WordCloudResponse/{id}")
    public Map getquestionsById(@PathVariable("id") String id) {
        return responsesService.getWCResponse(id);
    }

    //post WC response
    @PostMapping("/WordCloudresponses")
    public String saveNewWcResponses(@RequestBody Responses quest) {
        return responsesService.saveNewWcResponses(quest);

    }

    //put WC response
    @PutMapping("/WordCloudResponse/{id}")
    public String saveWCResponses(@RequestBody Responses quest, @PathVariable("id") String id) {
        try {
            return responsesService.saveWCResponses(quest,id);

        } catch (Exception e) {
            return responsesService.saveNewWcResponses(quest);
        }
    }





}
