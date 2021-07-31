package com.example.synergybackend.controller;
import com.example.synergybackend.model.Choice;
import com.example.synergybackend.model.QandAResponse;
import com.example.synergybackend.repository.QandAResponseRepository;
import com.example.synergybackend.services.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class QandAResponseController {
    @Autowired
    private QandAResponseRepository qandAResponseRepository;
    @Autowired
    private SequenceService service;

    @GetMapping("/QandAResponse")
    public List<QandAResponse> getquestions(){
        return qandAResponseRepository.findAll();
    }
    @GetMapping("/QandAResponse/{id}")
    public QandAResponse getquestionsById(@PathVariable("id") Long id){

        return qandAResponseRepository.findById(id).get();
    }

    @PostMapping("/QandAResponse")
    public String saveResponses(@RequestBody QandAResponse quest) {
        QandAResponse qandAResponse=new QandAResponse();
        qandAResponse.setId(service.getSequence(QandAResponse.SEQUENCE_NUMBER));
        qandAResponse.setResponses( quest.getResponses());
        qandAResponseRepository.save(qandAResponse);

        return "choices";
    }
}
