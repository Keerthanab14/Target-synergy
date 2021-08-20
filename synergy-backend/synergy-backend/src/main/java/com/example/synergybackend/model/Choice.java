package com.example.synergybackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Objects;
//@Document(collection = "choices")
public class Choice {

    private String choice;
    private int count;



    public Choice() {

    }

    public Choice(String choice,int count) {
        this.choice = choice;
        this.count = count;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {

        this.choice = choice;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
