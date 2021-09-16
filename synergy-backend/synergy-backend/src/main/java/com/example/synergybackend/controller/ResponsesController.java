package com.example.synergybackend.controller;

import com.example.synergybackend.model.Responses;
import com.example.synergybackend.repository.ResponsesRepository;
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
    private ResponsesRepository responsesRepository;

    //get responses
    @GetMapping("/responses")
    public List<Responses> getAllResponses() {
        return responsesRepository.findAll();
    }

    //get responses by ID
    @GetMapping("/responses/{id}")
    public Responses getResponsesById(@PathVariable("id") String id) {
        return responsesRepository.findById(id).get();
    }

    //get by Question ID
    @GetMapping("/quest/{id}")
    public String getQuestionById(@PathVariable("id") String id){
        Responses response = responsesRepository.findByQuestion(id);
        String url = response.getId();
        return url;
    }

    //add responses
    @PutMapping("/responses/{id}")
    public String saveResponses(@RequestBody Responses quest, @PathVariable("id") String id) {
        try
        {
            responsesRepository.findById(id).get();
            Responses responses = responsesRepository.findById(id).get();
            responses.setLatestAnswer(quest.getLatestAnswer());
            responses.setResponses(responses.getResponses());
            Responses savedResponse = responsesRepository.save(responses);
            String url = "responses/" + savedResponse.getId();
            return url;

        } catch (Exception e) {
            return saveNewResponses(quest);
        }
    }

    //post response
    @PostMapping("/responses")
    public String saveNewResponses(@RequestBody Responses quest) {
        Responses responses = new Responses();
        responses.setQuestion(quest.getQuestion());
        responses.setLatestAnswer(quest.getLatestAnswer());
        responses.setResponses(quest.getResponses());
        Responses savedResponse = responsesRepository.save(responses);
        String url = "responses/" + savedResponse.getId();
        return url;

    }

    //put WC response
    @PutMapping("/WordCloudResponse/{id}")
    public String saveWCResponses(@RequestBody Responses quest, @PathVariable("id") String id) {
        try {
            responsesRepository.findById(id).get();
            Responses responses = responsesRepository.findById(id).get();
            responses.setLatestAnswer(quest.getLatestAnswer());
            responses.setResponses(responses.getResponses());
            Responses savedResponse = responsesRepository.save(responses);
            String url = "WC/" + savedResponse.getId();
            return url;

        } catch (Exception e) {
            return saveNewWcResponses(quest);
        }
    }

    //post WC response
    @PostMapping("/WordCloudresponses")
    public String saveNewWcResponses(@RequestBody Responses quest) {
        Responses responses = new Responses();
        responses.setQuestion(quest.getQuestion());
        responses.setLatestAnswer(quest.getLatestAnswer());
        responses.setResponses(quest.getResponses());
        Responses savedResponse = responsesRepository.save(responses);
        String url = "WC/" + savedResponse.getId();
        return url;

    }

    //get Wc response
    @GetMapping("/WordCloudResponse/{id}")
    public Map getquestionsById(@PathVariable("id") String id) {
        Responses responses = responsesRepository.findById(id).get();
        ArrayList<String> resp = responses.getResponses();
        Map<String, Integer> hm = new HashMap<String, Integer>();
        for (String i : resp) {
            Integer j = hm.get(i);
            hm.put(String.valueOf(i), (j == null) ? 1 : j + 1);
        }
        return hm;
    }


}
