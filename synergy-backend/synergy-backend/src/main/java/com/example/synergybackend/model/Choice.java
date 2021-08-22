package com.example.synergybackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Objects;
//@Document(collection = "choices")
public class Choice {

    private String option;
    private int votes;

    public Choice(String option, int votes) {
        this.option = option;
        this.votes = votes;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
