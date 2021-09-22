package com.example.synergybackend.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.synergybackend.model.Choice;
import com.example.synergybackend.model.Mcq;
import com.example.synergybackend.model.Background;
import com.example.synergybackend.repository.MCQRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class McqControllerTest {

    @Mock
    private MCQRepository mockMcqRepo;

    @InjectMocks
    private McqController mcqControllerUnderTest;


    @Test
    void testGetAllMcq() {
        // Setup

     
        final Mcq mcq = new Mcq();
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        mcq.setBg(new Background(1,"white","black"));
        final List<Mcq> mcqs = List.of(mcq);
        when(mockMcqRepo.findAll()).thenReturn(mcqs);
        System.out.println(mcq);
        // Run the test
        final List<Mcq> result = mcqControllerUnderTest.getAllMcq();

        // Verify the results
        for(Mcq i :result)
            System.out.println(i);
    }

    @Test
    void testGetAllMcq_MCQRepositoryReturnsNoItems() {
        // Setup
        when(mockMcqRepo.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Mcq> result = mcqControllerUnderTest.getAllMcq();

        // Verify the results
        System.out.println(result);
    }

    @Test
    void testGetMcqById() {
        // Setup

        
        MockitoAnnotations.openMocks(this);
        final Mcq mcq1 = new Mcq();
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        mcq1.setBg(new Background(1,"white","black"));

        mockMcqRepo.save(any(Mcq.class));


        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Run the test
        final Mcq result = mcqControllerUnderTest.getMcqById("id");
        System.out.println(result);

    }

    @Test
    void testSaveMcq() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        quest.setBg(new Background(1,"white","black"));


        // Configure MCQRepository.save(...).
        final Mcq mcq = new Mcq();
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        mcq.setBg(new Background(1,"white","black"));

        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq);

        // Run the test
        final String result = mcqControllerUnderTest.saveMcq(quest);
        System.out.println(result);
        // Verify the results
        assertEquals("MCQ/id", result);
    }

    @Test
    void testUpdateMcq() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(List.of(new Choice("option", 2))));
        quest.setBg(new Background(1,"white","black"));


        // Configure MCQRepository.findById(...).
        final Mcq mcq1 = new Mcq();
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        mcq1.setBg(new Background(1,"white","black"));

        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Configure MCQRepository.save(...).
        final Mcq mcq2 = new Mcq();
        mcq2.setGoogleId("googleId");
        mcq2.setId("id");
        mcq2.setQuestion("question");
        mcq2.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        mcq2.setBg(new Background(1,"white","black"));

        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq2);

        // Run the test
        final Mcq result = mcqControllerUnderTest.updateMcq("id", quest);
        ArrayList<Choice> c=result.getChoices();
        for(Choice i:c)
            System.out.println(i.getVotes());

        
    }

    @Test
    void testSaveSC() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        quest.setBg(new Background(1,"white","black"));


        // Configure MCQRepository.save(...).
        final Mcq mcq = new Mcq();
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        mcq.setBg(new Background(1,"white","black"));

        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq);

        // Run the test
        final String result = mcqControllerUnderTest.saveSC(quest);

        // Verify the results
        assertEquals("SC/id", result);
    }

    @Test
    void testUpdateSC() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        quest.setBg(new Background(1,"white","black"));


    
        final Mcq mcq1 = new Mcq();
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        mcq1.setBg(new Background(1,"white","black"));

        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        final Mcq mcq2 = new Mcq();
        mcq2.setGoogleId("googleId");
        mcq2.setId("id");
        mcq2.setQuestion("question");
        mcq2.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        mcq2.setBg(new Background(1,"white","black"));

        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq2);

        // Run the test
        final Mcq result = mcqControllerUnderTest.updateSC("id", quest);

        // Verify the results
    }

    @Test
    void testGetSC() {
        // Setup

     
        final Mcq mcq1 = new Mcq();
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        mcq1.setBg(new Background(1,"white","black"));

        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Run the test
        final Mcq result = mcqControllerUnderTest.getSC("id");

    }

    @Test
    void testSaveRT() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        quest.setBg(new Background(1,"white","black"));

      
        final Mcq mcq = new Mcq();
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        mcq.setBg(new Background(1,"white","black"));

        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq);

        // Run the test
        final String result = mcqControllerUnderTest.saveRT(quest);

        // Verify the results
        assertEquals("RT/id", result);
    }

    @Test
    void testUpdateRT() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        quest.setBg(new Background(1,"white","black"));



        final Mcq mcq1 = new Mcq();
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        mcq1.setBg(new Background(1,"white","black"));

        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Configure MCQRepository.save(...).
        final Mcq mcq2 = new Mcq();
        mcq2.setGoogleId("googleId");
        mcq2.setId("id");
        mcq2.setQuestion("question");
        mcq2.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        mcq2.setBg(new Background(1,"white","black"));

        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq2);

        // Run the test
        final Mcq result = mcqControllerUnderTest.updateRT("id", quest);

    }

    @Test
    void testGetRT() {
        // Setup

    
        final Mcq mcq1 = new Mcq();
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        mcq1.setBg(new Background(1,"white","black"));

        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Run the test
        final Mcq result = mcqControllerUnderTest.getRT("id");

    }

}
