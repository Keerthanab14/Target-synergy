package com.example.synergybackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "polls")
public class Poll {
    @Id
    private String id;
    private String question;
    private ArrayList<Choice> choices ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<Choice> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<Choice> choices) {
        this.choices = choices;
    }

//    public void addChoice(Choice choice) {
//        choices.add(choice);
//        choice.setPoll(this);
//    }
//
//    public void removeChoice(Choice choice) {
//        choices.remove(choice);
//        choice.setPoll(null);
//    }

}
