package com.example.synergybackend.controller;
import com.example.synergybackend.model.OpenEnded;
import com.example.synergybackend.model.QandA;
import com.example.synergybackend.repository.QandARepository;
import com.example.synergybackend.services.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QSort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class QandAController {

    @Autowired
    private QandARepository qandARepository;
    @Autowired
    private SequenceService service;

    @GetMapping("/QandA")
    public List<QandA> getquestions(){
        return qandARepository.findAll();
    }
    @GetMapping("/QandA/{id}")
    public QandA getquestionsById(@PathVariable("id") Long id){

        return qandARepository.findById(id).get();
    }

    @PostMapping("/QandA")
    public String saveQuestions(@RequestBody QandA quest) {
        QandA qandA=new QandA();
       // qandA.setId(service.getSequence(OpenEnded.SEQUENCE_NUMBER));
        qandA.setQuestion( quest.getQuestion());
        QandA saved=qandARepository.save(qandA);
        String url = "/QandA/" + qandA.getId();
        return url;
    }

}
