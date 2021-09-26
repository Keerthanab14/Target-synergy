package com.example.synergybackend.controller;

import com.example.synergybackend.model.Background;
import com.example.synergybackend.model.Choice;
import com.example.synergybackend.model.Mcq;
import com.example.synergybackend.service.McqService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class McqControllerTest {

    @Mock
    private McqService mockMcqService;

    @InjectMocks
    private McqController mcqControllerUnderTest;

    private AutoCloseable mockitoCloseable;

    @BeforeEach
    void setUp() {
        mockitoCloseable = openMocks(this);
    }
//close after each test
    @AfterEach
    void tearDown() throws Exception {
        mockitoCloseable.close();
    }

    @Test
    void testGetMcqByUser() {
        // Setup
        //create two mcq objects of a single googleid and see if both can be retrieved properly

        // Configure McqService.getMcqByUser(...).
        final Mcq mcq = new Mcq();
        mcq.setBg(new Background(0, "bgColor", "textColor"));
        mcq.setType("type");
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));

        final Mcq mcq1 = new Mcq();
        mcq1.setBg(new Background(0, "bgColor", "textColor"));
        mcq1.setType("type1");
        mcq1.setGoogleId("googleId");
        mcq1.setId("id1");
        mcq1.setQuestion("question1");
        mcq1.setChoices(new ArrayList<>(List.of(new Choice("option1", 0))));
        //list initialization
        final List<Mcq> mcqs = List.of(mcq,mcq1);
        when(mockMcqService.getMcqByUser("googleId")).thenReturn(mcqs);

        // Run the test
        final List<Mcq> result = mcqControllerUnderTest.getMcqByUser("googleId");

        // Verify the results
        for(Mcq i :result)
            System.out.println(i);
    }

    @Test
    void testGetMcqById() {
        // Setup

        // Configure McqService.getMcqById(...).
        final Mcq mcq = new Mcq();
        mcq.setBg(new Background(0, "bgColor", "textColor"));
        mcq.setType("type");
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        when(mockMcqService.getMcqById("id")).thenReturn(mcq);

        // Run the test
        final Mcq result = mcqControllerUnderTest.getMcqById("id");

        // Verify the results
        System.out.println(result);
    }


    @Test
    void testSaveMcq() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setBg(new Background(0, "bgColor", "textColor"));
        quest.setType("type");
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));

        when(mockMcqService.saveMcq(any(Mcq.class))).thenReturn("MCQ/id");

        // Run the test
        final String result = mcqControllerUnderTest.saveMcq(quest);

        // Verify the results
        assertEquals("MCQ/id", result);
    }

    @Test
    void testSaveWithBg() {
        // Setup
        final Background quest = new Background(0, "bgColor", "textColor");
        when(mockMcqService.saveWithBg(eq("id"), any(Background.class))).thenReturn("MCQ/id");

        // Run the test
        final String result = mcqControllerUnderTest.saveWithBg("id", quest);

        // Verify the results
        assertEquals("MCQ/id", result);
    }

    @Test
    void testUpdateMcq() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setBg(new Background(0, "bgColor", "textColor"));
        quest.setType("type");
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));

        // Configure McqService.updateMcq(...).
        final Mcq mcq = new Mcq();
        mcq.setBg(new Background(0, "bgColor", "textColor"));
        mcq.setType("type");
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        when(mockMcqService.updateMcq(eq("id"), any(Mcq.class))).thenReturn(mcq);

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
        quest.setBg(new Background(0, "bgColor", "textColor"));
        quest.setType("type");
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));

        when(mockMcqService.saveSC(any(Mcq.class))).thenReturn("SC/id");

        // Run the test
        final String result = mcqControllerUnderTest.saveSC(quest);

        // Verify the results
        assertEquals("SC/id", result);
    }

    @Test
    void testUpdateSC() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setBg(new Background(0, "bgColor", "textColor"));
        quest.setType("type");
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));

        // Configure McqService.updateSC(...).
        final Mcq mcq = new Mcq();
        mcq.setBg(new Background(0, "bgColor", "textColor"));
        mcq.setType("type");
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        when(mockMcqService.updateSC(eq("id"), any(Mcq.class))).thenReturn(mcq);

        // Run the test
        final Mcq result = mcqControllerUnderTest.updateSC("id", quest);

    }

    @Test
    void testSaveWithB() {
        // Setup
        final Background quest = new Background(0, "bgColor", "textColor");
        when(mockMcqService.saveWithB(eq("id"), any(Background.class))).thenReturn("SC/id");

        // Run the test
        final String result = mcqControllerUnderTest.saveWithB("id", quest);

        // Verify the results
        assertEquals("SC/id", result);
    }

    @Test
    void testGetSC() {
        // Setup

        // Configure McqService.getSC(...).
        final Mcq mcq = new Mcq();
        mcq.setBg(new Background(0, "bgColor", "textColor"));
        mcq.setType("type");
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        when(mockMcqService.getSC("id")).thenReturn(mcq);

        // Run the test
        final Mcq result = mcqControllerUnderTest.getSC("id");


    }

    @Test
    void testSaveRT() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setBg(new Background(0, "bgColor", "textColor"));
        quest.setType("type");
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));

        when(mockMcqService.saveRT(any(Mcq.class))).thenReturn("RT/id");

        // Run the test
        final String result = mcqControllerUnderTest.saveRT(quest);

        // Verify the results
        assertEquals("RT/id", result);
    }

    @Test
    void testUpdateRT() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setBg(new Background(0, "bgColor", "textColor"));
        quest.setType("type");
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));

        // Configure McqService.updateRT(...).
        final Mcq mcq = new Mcq();
        mcq.setBg(new Background(0, "bgColor", "textColor"));
        mcq.setType("type");
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        when(mockMcqService.updateRT(eq("id"), any(Mcq.class))).thenReturn(mcq);

        // Run the test
        final Mcq result = mcqControllerUnderTest.updateRT("id", quest);


    }

    @Test
    void testSaveBg() {
        // Setup
        final Background quest = new Background(0, "bgColor", "textColor");
        when(mockMcqService.saveBg(eq("id"), any(Background.class))).thenReturn("RT/id");

        // Run the test
        final String result = mcqControllerUnderTest.saveBg("id", quest);

        // Verify the results
        assertEquals("RT/id", result);
    }

    @Test
    void testGetRT() {
        // Setup

        // Configure McqService.getRT(...).
        final Mcq mcq = new Mcq();
        mcq.setBg(new Background(0, "bgColor", "textColor"));
        mcq.setType("type");
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        when(mockMcqService.getRT("id")).thenReturn(mcq);

        // Run the test
        final Mcq result = mcqControllerUnderTest.getRT("id");
    }
}
