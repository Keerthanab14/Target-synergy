package com.example.synergybackend.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "WordCloudResponse")
public class WordCloudResponse {
    @Transient
    public static final String SEQUENCE_NUMBER ="user_sequence";
    @Id
    private int id;
    private ArrayList<Choice> responses ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Choice> getResponses() {
        return responses;
    }

    public void setResponses(ArrayList<Choice> responses) {
        this.responses = responses;
    }
}
