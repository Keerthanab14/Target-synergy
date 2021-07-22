package com.example.synergybackend.payLoad;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
public class PollRequest {
    private String question;
   //from db private List<ChoiceRequest> choices;
    //from db private PollLength pollLength;
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
//should be rendered from db
   /* public List<ChoiceRequest> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoiceRequest> choices) {
        this.choices = choices;
    }

    public PollLength getPollLength() {
        return pollLength;
    }

    public void setPollLength(PollLength pollLength) {
        this.pollLength = pollLength;
    }*/
}
