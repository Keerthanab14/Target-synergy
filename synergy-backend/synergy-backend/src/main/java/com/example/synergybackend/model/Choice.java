package com.example.synergybackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.util.Objects;
@Document(collection = "choices")
public class Choice {
    @Id
    //auto generate value
    private int id;
    @Size(max = 50)
    private String text;

    private Poll poll;

    public Choice() {

    }

    public Choice(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Choice choice = (Choice) o;
        return Objects.equals(id, choice.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
