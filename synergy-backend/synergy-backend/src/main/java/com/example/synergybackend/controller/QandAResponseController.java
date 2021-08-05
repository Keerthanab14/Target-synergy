package com.example.synergybackend.controller;
import com.example.synergybackend.model.QandAResponse;
import com.example.synergybackend.repository.QandAResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class QandAResponseController {
    @Autowired
    private QandAResponseRepository qandAResponseRepository;

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
        qandAResponse.setResponses( quest.getResponses());
        qandAResponseRepository.save(qandAResponse);

        return "choices";
    }
}
