package com.example.synergybackend.service;

import com.example.synergybackend.model.Background;
import com.example.synergybackend.model.Choice;
import com.example.synergybackend.model.Mcq;
import com.example.synergybackend.repository.MCQRepository;
import com.example.synergybackend.service.McqService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class McqServiceTest {

    @Mock
    private MCQRepository mockMcqRepo;

    @InjectMocks
    private McqService mcqServiceUnderTest;

    private AutoCloseable mockitoCloseable;

    @BeforeEach
    void setUp() {
        mockitoCloseable = openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        mockitoCloseable.close();
    }

    @Test
    void testGetMcqByUser() {
        // Setup

        // Configure MCQRepository.findAllByGoogleId(...).
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
        mockMcqRepo.save(mcq);
        mockMcqRepo.save(mcq1);
        final List<Mcq> mcqs = List.of(mcq,mcq1);
        when(mockMcqRepo.findAllByGoogleId("id")).thenReturn(mcqs);

        // Run the test
        final List<Mcq> result = mcqServiceUnderTest.getMcqByUser("id");

        // Verify the results
        for(Mcq i :result)
            System.out.println(i);
    }

    @Test
    void testGetMcqById() {
        // Setup

        // Configure MCQRepository.findById(...).
        final Mcq mcq1 = new Mcq();
        mcq1.setBg(new Background(0, "bgColor", "textColor"));
        mcq1.setType("type");
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Run the test
        final Mcq result = mcqServiceUnderTest.getMcqById("id");

        // Verify the results
    }

    @Test
    void testGetAllMcq() {
        // Setup

        // Configure MCQRepository.findAll(...).
        final Mcq mcq = new Mcq();
        mcq.setBg(new Background(0, "bgColor", "textColor"));
        mcq.setType("type");
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        final List<Mcq> mcqs = List.of(mcq);
        when(mockMcqRepo.findAll()).thenReturn(mcqs);

        // Run the test
        final List<Mcq> result = mcqServiceUnderTest.getAllMcq();

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

        // Configure MCQRepository.save(...).
        final Mcq mcq = new Mcq();
        mcq.setBg(new Background(0, "bgColor", "textColor"));
        mcq.setType("type");
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq);

        // Run the test
        final String result = mcqServiceUnderTest.saveMcq(quest);

        // Verify the results
        assertThat(result).isEqualTo("MCQ/id");
    }

    @Test
    void testSaveWithBg() {
        // Setup
        final Background quest = new Background(0, "bgColor", "textColor");

        // Configure MCQRepository.findById(...).
        final Mcq mcq1 = new Mcq();
        mcq1.setBg(new Background(0, "bgColor", "textColor"));
        mcq1.setType("type");
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Configure MCQRepository.save(...).
        final Mcq mcq2 = new Mcq();
        mcq2.setBg(new Background(0, "bgColor", "textColor"));
        mcq2.setType("type");
        mcq2.setGoogleId("googleId");
        mcq2.setId("id");
        mcq2.setQuestion("question");
        mcq2.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq2);

        // Run the test
        final String result = mcqServiceUnderTest.saveWithBg("id", quest);

        // Verify the results
        assertThat(result).isEqualTo("MCQ/id");
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

        // Configure MCQRepository.findById(...).
        final Mcq mcq1 = new Mcq();
        mcq1.setBg(new Background(0, "bgColor", "textColor"));
        mcq1.setType("type");
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Configure MCQRepository.save(...).
        final Mcq mcq2 = new Mcq();
        mcq2.setBg(new Background(0, "bgColor", "textColor"));
        mcq2.setType("type");
        mcq2.setGoogleId("googleId");
        mcq2.setId("id");
        mcq2.setQuestion("question");
        mcq2.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq2);

        // Run the test
        final Mcq result = mcqServiceUnderTest.updateMcq("id", quest);

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

        // Configure MCQRepository.save(...).
        final Mcq mcq = new Mcq();
        mcq.setBg(new Background(0, "bgColor", "textColor"));
        mcq.setType("type");
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq);

        // Run the test
        final String result = mcqServiceUnderTest.saveSC(quest);

        // Verify the results
        assertThat(result).isEqualTo("SC/id");
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

        // Configure MCQRepository.findById(...).
        final Mcq mcq1 = new Mcq();
        mcq1.setBg(new Background(0, "bgColor", "textColor"));
        mcq1.setType("type");
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Configure MCQRepository.save(...).
        final Mcq mcq2 = new Mcq();
        mcq2.setBg(new Background(0, "bgColor", "textColor"));
        mcq2.setType("type");
        mcq2.setGoogleId("googleId");
        mcq2.setId("id");
        mcq2.setQuestion("question");
        mcq2.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq2);

        // Run the test
        final Mcq result = mcqServiceUnderTest.updateSC("id", quest);

    }

    @Test
    void testSaveWithB() {
        // Setup
        final Background quest = new Background(0, "bgColor", "textColor");

        // Configure MCQRepository.findById(...).
        final Mcq mcq1 = new Mcq();
        mcq1.setBg(new Background(0, "bgColor", "textColor"));
        mcq1.setType("type");
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Configure MCQRepository.save(...).
        final Mcq mcq2 = new Mcq();
        mcq2.setBg(new Background(0, "bgColor", "textColor"));
        mcq2.setType("type");
        mcq2.setGoogleId("googleId");
        mcq2.setId("id");
        mcq2.setQuestion("question");
        mcq2.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq2);

        // Run the test
        final String result = mcqServiceUnderTest.saveWithB("id", quest);

        // Verify the results
        assertThat(result).isEqualTo("SC/id");
    }

    @Test
    void testGetSC() {
        // Setup

        // Configure MCQRepository.findById(...).
        final Mcq mcq1 = new Mcq();
        mcq1.setBg(new Background(0, "bgColor", "textColor"));
        mcq1.setType("type");
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Run the test
        final Mcq result = mcqServiceUnderTest.getSC("id");

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

        // Configure MCQRepository.save(...).
        final Mcq mcq = new Mcq();
        mcq.setBg(new Background(0, "bgColor", "textColor"));
        mcq.setType("type");
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq);

        // Run the test
        final String result = mcqServiceUnderTest.saveRT(quest);

        // Verify the results
        assertThat(result).isEqualTo("RT/id");
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

        // Configure MCQRepository.findById(...).
        final Mcq mcq1 = new Mcq();
        mcq1.setBg(new Background(0, "bgColor", "textColor"));
        mcq1.setType("type");
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Configure MCQRepository.save(...).
        final Mcq mcq2 = new Mcq();
        mcq2.setBg(new Background(0, "bgColor", "textColor"));
        mcq2.setType("type");
        mcq2.setGoogleId("googleId");
        mcq2.setId("id");
        mcq2.setQuestion("question");
        mcq2.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq2);

        // Run the test
        final Mcq result = mcqServiceUnderTest.updateRT("id", quest);

    }

    @Test
    void testSaveBg() {
        // Setup
        final Background quest = new Background(0, "bgColor", "textColor");

        // Configure MCQRepository.findById(...).
        final Mcq mcq1 = new Mcq();
        mcq1.setBg(new Background(0, "bgColor", "textColor"));
        mcq1.setType("type");
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Configure MCQRepository.save(...).
        final Mcq mcq2 = new Mcq();
        mcq2.setBg(new Background(0, "bgColor", "textColor"));
        mcq2.setType("type");
        mcq2.setGoogleId("googleId");
        mcq2.setId("id");
        mcq2.setQuestion("question");
        mcq2.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq2);

        // Run the test
        final String result = mcqServiceUnderTest.saveBg("id", quest);

        // Verify the results
        assertThat(result).isEqualTo("RT/id");
    }


    @Test
    void testGetRT() {
        // Setup

        // Configure MCQRepository.findById(...).
        final Mcq mcq1 = new Mcq();
        mcq1.setBg(new Background(0, "bgColor", "textColor"));
        mcq1.setType("type");
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(List.of(new Choice("option", 0))));
        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Run the test
        final Mcq result = mcqServiceUnderTest.getRT("id");

    }

}
