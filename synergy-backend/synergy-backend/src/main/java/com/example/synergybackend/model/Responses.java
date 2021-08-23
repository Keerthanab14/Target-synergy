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
    private String question;
    private String latestAnswer;
    private String googleId;
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }
}
