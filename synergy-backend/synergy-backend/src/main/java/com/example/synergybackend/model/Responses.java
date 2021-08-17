package com.example.synergybackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "responses")
public class Responses {
    @Id
    private String id;
    private String latestAnswer;
    private ArrayList<String> responses=new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLatestAnswer() {
        return latestAnswer;
    }

    public String setLatestAnswer(String latestAnswer) {
        this.latestAnswer = latestAnswer;
        return latestAnswer;
    }

    public ArrayList<String> getResponses() {
        return responses;
    }

    public void setResponses(ArrayList<String> responses) {
        this.latestAnswer = latestAnswer;
        this.responses=responses;

        responses.add(latestAnswer) ;
    }

}
