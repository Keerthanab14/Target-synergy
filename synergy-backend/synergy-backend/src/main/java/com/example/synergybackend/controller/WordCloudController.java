package com.example.synergybackend.controller;
import com.example.synergybackend.model.Choice;
import com.example.synergybackend.model.WordCloud;
import com.example.synergybackend.repository.PollRepository;
import com.example.synergybackend.repository.QandARepository;
import com.example.synergybackend.repository.WordCloudRepository;
import com.example.synergybackend.services.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class WordCloudController {
    @Autowired
    private WordCloudRepository wordCloudRepository;
    @Autowired
    private SequenceService service;

    @GetMapping("/WordCloud")
    public String getquestion(){
        return String.valueOf(wordCloudRepository.findAll());
    }
    @GetMapping("/WordCloud/{id}")
    public WordCloud getquestionsById(@PathVariable("id") Long id){

        return wordCloudRepository.findById(id).get();
    }

    @PostMapping("/WordCloud")
    public String saveQuestion(@RequestBody WordCloud quest) {
        WordCloud wordCloud=new WordCloud();
        wordCloud.setId(service.getSequence(WordCloud.SEQUENCE_NUMBER));
        wordCloud.setQuestion( quest.getQuestion());
        wordCloudRepository.save(wordCloud);
        return"successful";
    }
}
