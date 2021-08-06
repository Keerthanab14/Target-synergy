package com.example.synergybackend.controller;
import com.example.synergybackend.model.Choice;
import com.example.synergybackend.model.WordCloudResponse;
import com.example.synergybackend.repository.WordCloudResponseRespository;
import com.example.synergybackend.services.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class WordCloudResponseController {
    @Autowired
    private WordCloudResponseRespository wordCloudResponseRespository;
    @Autowired
    private SequenceService service;

    @GetMapping("/WordCloudResponse")
    public List<WordCloudResponse> getquestion(){
        return wordCloudResponseRespository.findAll();
    }
    @GetMapping("/WordCloudResponse/{id}")
    public Map getquestionsById(@PathVariable("id") Long id){

        WordCloudResponse responses =  wordCloudResponseRespository.findById(id).get();
        ArrayList<Choice> resp=responses.getResponses();
        Map<String, Integer> hm = new HashMap<String, Integer>();

        for (Choice i : resp) {
            Integer j = hm.get(i.getText());
            hm.put(String.valueOf(i.getText()), (j == null) ? 1 : j + 1);
        }

        // displaying the occurrence of elements in the arraylist
        for (Map.Entry<String, Integer> val : hm.entrySet()) {
            System.out.println("Element " + val.getKey()+ " "
                    + "occurs"
                    + ": " + val.getValue() + " times");
        }
        return hm;
    }
    @PostMapping("/WordCloudResponse")
    public String saveResponses(@RequestBody WordCloudResponse quest) {
        WordCloudResponse wordCloudResponse=new WordCloudResponse();
        wordCloudResponse.setId(service.getSequence(WordCloudResponse.SEQUENCE_NUMBER));
        wordCloudResponse.setResponses( quest.getResponses());
        wordCloudResponseRespository.save(wordCloudResponse);
        String url = "/wordCloud" + wordCloudResponse.getId();
        return url;
    }
}
