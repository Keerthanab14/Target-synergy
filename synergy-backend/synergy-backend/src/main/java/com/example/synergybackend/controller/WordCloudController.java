package com.example.synergybackend.controller;
import com.example.synergybackend.model.WordCloud;
import com.example.synergybackend.repository.WordCloudRepository;
import com.example.synergybackend.services.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.synergybackend.model.OpenEnded;

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

        return (WordCloud) wordCloudRepository.findById(id).get();
    }

    @PostMapping("/WordCloud")
    public String saveQuestion(@RequestBody WordCloud quest) {
        WordCloud wordCloud = new WordCloud();
        wordCloud.setId(service.getSequence(WordCloud.SEQUENCE_NUMBER));
        wordCloud.setQuestion(quest.getQuestion());
        wordCloudRepository.save(wordCloud);
        String url = "/WordCloud/" + wordCloud.getId();
        return url;
    }

}
