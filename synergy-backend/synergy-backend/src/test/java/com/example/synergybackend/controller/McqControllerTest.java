package com.example.synergybackend.controller;

import com.example.synergybackend.model.Choice;
import com.example.synergybackend.model.Mcq;
import com.example.synergybackend.repository.MCQRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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

        // Configure MCQRepository.findAll(...).
        final Mcq mcq = new Mcq();
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));
        final List<Mcq> mcqs = Arrays.asList(mcq);
        when(mockMcqRepo.findAll()).thenReturn(mcqs);

        // Run the test
        final List<Mcq> result = mcqControllerUnderTest.getAllMcq();

        // Verify the results
    }

    @Test
    void testGetAllMcq_MCQRepositoryReturnsNoItems() {
        // Setup
        when(mockMcqRepo.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Mcq> result = mcqControllerUnderTest.getAllMcq();

        // Verify the results
    }

    @Test
    void testGetMcqById() {
        // Setup

        // Configure MCQRepository.findById(...).
        final Mcq mcq1 = new Mcq();
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));
        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Run the test
        final Mcq result = mcqControllerUnderTest.getMcqById("id");

        // Verify the results
    }

    @Test
    void testGetMcqById_MCQRepositoryReturnsAbsent() {
        // Setup
        when(mockMcqRepo.findById("id")).thenReturn(Optional.empty());

        // Run the test
        final Mcq result = mcqControllerUnderTest.getMcqById("id");

        // Verify the results
    }

    @Test
    void testSaveMcq() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));

        // Configure MCQRepository.save(...).
        final Mcq mcq = new Mcq();
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));
        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq);

        // Run the test
        final String result = mcqControllerUnderTest.saveMcq(quest);

        // Verify the results
        assertEquals("result", result);
    }

    @Test
    void testUpdateMcq() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));

        // Configure MCQRepository.findById(...).
        final Mcq mcq1 = new Mcq();
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));
        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Configure MCQRepository.save(...).
        final Mcq mcq2 = new Mcq();
        mcq2.setGoogleId("googleId");
        mcq2.setId("id");
        mcq2.setQuestion("question");
        mcq2.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));
        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq2);

        // Run the test
        final Mcq result = mcqControllerUnderTest.updateMcq("id", quest);

        // Verify the results
    }

    @Test
    void testUpdateMcq_MCQRepositoryFindByIdReturnsAbsent() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));

        when(mockMcqRepo.findById("id")).thenReturn(Optional.empty());

        // Configure MCQRepository.save(...).
        final Mcq mcq = new Mcq();
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));
        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq);

        // Run the test
        final Mcq result = mcqControllerUnderTest.updateMcq("id", quest);

        // Verify the results
    }

    @Test
    void testSaveSC() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));

        // Configure MCQRepository.save(...).
        final Mcq mcq = new Mcq();
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));
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
        quest.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));

        // Configure MCQRepository.findById(...).
        final Mcq mcq1 = new Mcq();
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));
        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Configure MCQRepository.save(...).
        final Mcq mcq2 = new Mcq();
        mcq2.setGoogleId("googleId");
        mcq2.setId("id");
        mcq2.setQuestion("question");
        mcq2.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));
        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq2);

        // Run the test
        final Mcq result = mcqControllerUnderTest.updateSC("id", quest);

        // Verify the results
    }

    @Test
    void testUpdateSC_MCQRepositoryFindByIdReturnsAbsent() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));

        when(mockMcqRepo.findById("id")).thenReturn(Optional.empty());

        // Configure MCQRepository.save(...).
        final Mcq mcq = new Mcq();
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));
        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq);

        // Run the test
        final Mcq result = mcqControllerUnderTest.updateSC("id", quest);

        // Verify the results
    }

    @Test
    void testGetSC() {
        // Setup

        // Configure MCQRepository.findById(...).
        final Mcq mcq1 = new Mcq();
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));
        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Run the test
        final Mcq result = mcqControllerUnderTest.getSC("id");

        // Verify the results
    }

    @Test
    void testGetSC_MCQRepositoryReturnsAbsent() {
        // Setup
        when(mockMcqRepo.findById("id")).thenReturn(Optional.empty());

        // Run the test
        final Mcq result = mcqControllerUnderTest.getSC("id");

        // Verify the results
    }

    @Test
    void testSaveRT() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));

        // Configure MCQRepository.save(...).
        final Mcq mcq = new Mcq();
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));
        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq);

        // Run the test
        final String result = mcqControllerUnderTest.saveRT(quest);

        // Verify the results
        assertEquals("result", result);
    }

    @Test
    void testUpdateRT() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));

        // Configure MCQRepository.findById(...).
        final Mcq mcq1 = new Mcq();
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));
        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Configure MCQRepository.save(...).
        final Mcq mcq2 = new Mcq();
        mcq2.setGoogleId("googleId");
        mcq2.setId("id");
        mcq2.setQuestion("question");
        mcq2.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));
        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq2);

        // Run the test
        final Mcq result = mcqControllerUnderTest.updateRT("id", quest);

        // Verify the results
    }

    @Test
    void testUpdateRT_MCQRepositoryFindByIdReturnsAbsent() {
        // Setup
        final Mcq quest = new Mcq();
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");
        quest.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));

        when(mockMcqRepo.findById("id")).thenReturn(Optional.empty());

        // Configure MCQRepository.save(...).
        final Mcq mcq = new Mcq();
        mcq.setGoogleId("googleId");
        mcq.setId("id");
        mcq.setQuestion("question");
        mcq.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));
        when(mockMcqRepo.save(any(Mcq.class))).thenReturn(mcq);

        // Run the test
        final Mcq result = mcqControllerUnderTest.updateRT("id", quest);

        // Verify the results
    }

    @Test
    void testGetRT() {
        // Setup

        // Configure MCQRepository.findById(...).
        final Mcq mcq1 = new Mcq();
        mcq1.setGoogleId("googleId");
        mcq1.setId("id");
        mcq1.setQuestion("question");
        mcq1.setChoices(new ArrayList<>(Arrays.asList(new Choice("option", 0))));
        final Optional<Mcq> mcq = Optional.of(mcq1);
        when(mockMcqRepo.findById("id")).thenReturn(mcq);

        // Run the test
        final Mcq result = mcqControllerUnderTest.getRT("id");

        // Verify the results
    }

    @Test
    void testGetRT_MCQRepositoryReturnsAbsent() {
        // Setup
        when(mockMcqRepo.findById("id")).thenReturn(Optional.empty());

        // Run the test
        final Mcq result = mcqControllerUnderTest.getRT("id");

        // Verify the results
    }
}
