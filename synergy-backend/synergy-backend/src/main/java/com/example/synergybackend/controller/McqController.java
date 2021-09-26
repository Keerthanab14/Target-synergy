package com.example.synergybackend.controller;


import com.example.synergybackend.model.Mcq;
import com.example.synergybackend.repository.MCQRepository;
import com.example.synergybackend.service.McqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.synergybackend.model.Background;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class McqController {
    @Autowired
    private McqService mcqService;

    //get mcq by user id
    @GetMapping("/{id}/MCQ")
    @ResponseBody
    public List<Mcq> getMcqByUser(@PathVariable("id") String id){
        return mcqService.getMcqByUser(id);
    }

    //get mcq by id
    @GetMapping("/MCQ/{id}")
    @ResponseBody
    public Mcq getMcqById(@PathVariable("id") String id){
        return mcqService.getMcqById(id);
    }

    //get all mcq
    @GetMapping("/MCQ")
    @ResponseBody
    public List<Mcq> getAllMcq(){
        return mcqService.getAllMcq();
    }

    //post mcq
    @PostMapping("/MCQ")
    @ResponseBody
    public String saveMcq(@RequestBody Mcq quest) {
        return mcqService.saveMcq(quest);
    }

    //bg for mcq
    @PutMapping("/MCQ/{id}/bg")
    @ResponseBody
    public String saveWithBg(@PathVariable("id") String id,@RequestBody Background quest) {
        return mcqService.saveWithBg(id,quest);
    }

    //update votes
    @PutMapping("/MCQ/{id}")
    @ResponseBody
    public Mcq updateMcq(@PathVariable("id") String id,@RequestBody Mcq quest) {
        return mcqService.updateMcq(id,quest);
    }

    //****SCALES****
    //post scales
    @PostMapping("/SC")
    @ResponseBody
    public String saveSC(@RequestBody Mcq quest) {
        return mcqService.saveSC(quest);
    }

    //responses for scales
    @PutMapping("/SC/{id}")
    @ResponseBody
    public Mcq updateSC(@PathVariable("id") String id,@RequestBody Mcq quest) {
        return mcqService.updateSC(id,quest);
    }

    //bg for scales
    @PutMapping("/SC/{id}/bg")
    @ResponseBody
    public String saveWithB(@PathVariable("id") String id,@RequestBody Background quest) {
        return mcqService.saveWithB(id,quest);
    }

    //get scales by id
    @GetMapping("/SC/{id}")
    @ResponseBody
    public Mcq getSC(@PathVariable("id") String id){
        return mcqService.getSC(id);
    }


    //****RATING****

    //post rating question
    @PostMapping("/RT")
    @ResponseBody
    public String saveRT(@RequestBody Mcq quest) {
        return mcqService.saveRT(quest);
    }

    //response for rating
    @PutMapping("/RT/{id}")
    @ResponseBody
    public Mcq updateRT(@PathVariable("id") String id,@RequestBody Mcq quest) {
        return mcqService.updateRT(id,quest);
    }

    //bg for rating
    @PutMapping("/RT/{id}/bg")
    @ResponseBody
    public String saveBg(@PathVariable("id") String id,@RequestBody Background quest) {
        return mcqService.saveBg(id,quest);
    }

    //get rating by id
    @GetMapping("/RT/{id}")
    @ResponseBody
    public Mcq getRT(@PathVariable("id") String id){
        return mcqService.getRT(id);
    }

}
