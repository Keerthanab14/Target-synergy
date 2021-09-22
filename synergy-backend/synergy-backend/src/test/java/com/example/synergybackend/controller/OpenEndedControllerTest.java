package com.example.synergybackend.controller;

import com.example.synergybackend.model.Background;
import com.example.synergybackend.model.OpenEnded;
import com.example.synergybackend.repository.OpenEndedRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OpenEndedControllerTest {

    @Mock
    private OpenEndedRepository mockOpenEndedRepository;

    @InjectMocks
    private OpenEndedController openEndedControllerUnderTest;

    @Test
    void testGetAllquestion() {
        // Setup

        
        final OpenEnded openEnded = new OpenEnded();
        openEnded.setId("id");
        openEnded.setQuestion("question");
        openEnded.setBg(new Background(20,"blue","black"));
        final List<OpenEnded> openEndeds = Arrays.asList(openEnded);
        when(mockOpenEndedRepository.findAll()).thenReturn(openEndeds);

        // Run the test
        final List<OpenEnded> result = openEndedControllerUnderTest.getAllquestion();

    }

    @Test
    void testGetAllquestion_OpenEndedRepositoryReturnsNoItems() {
        // Setup
        when(mockOpenEndedRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<OpenEnded> result = openEndedControllerUnderTest.getAllquestion();

    }

    @Test
    void testSaveQuestion() {
        // Setup
        final OpenEnded quest = new OpenEnded();
        quest.setId("id");
        quest.setQuestion("question");
        quest.setBg(new Background(20,"blue","black"));


        // Configure OpenEndedRepository.save(...).
        final OpenEnded openEnded = new OpenEnded();
        openEnded.setId("id");
        openEnded.setQuestion("question");
        openEnded.setBg(new Background(20,"blue","black"));

        when(mockOpenEndedRepository.save(any(OpenEnded.class))).thenReturn(openEnded);

        // Run the test
        final String result = openEndedControllerUnderTest.saveQuestion(quest);

        // Verify the results
        assertEquals("OE/id", result);
    }

    @Test
    void testGetOpenEndedquestion() {
    

        // Configure OpenEndedRepository.findById(...).
        final OpenEnded openEnded1 = new OpenEnded();
        openEnded1.setId("id");
        openEnded1.setQuestion("question");
        openEnded1.setBg(new Background(20,"blue","black"));

        final Optional<OpenEnded> openEnded = Optional.of(openEnded1);
        when(mockOpenEndedRepository.findById("id")).thenReturn(openEnded);

        // Run the test
        final OpenEnded result = openEndedControllerUnderTest.getOpenEndedquestion("id");

  
    }


    @Test
    void testSavewcQuestion() {
        // Setup
        final OpenEnded quest = new OpenEnded();
        quest.setId("id");
        quest.setQuestion("question");
        quest.setBg(new Background(20,"blue","black"));


        // Configure OpenEndedRepository.save(...).
        final OpenEnded openEnded = new OpenEnded();
        openEnded.setId("id");
        openEnded.setQuestion("question");
        openEnded.setBg(new Background(20,"blue","black"));

        when(mockOpenEndedRepository.save(any(OpenEnded.class))).thenReturn(openEnded);

        // Run the test
        final String result = openEndedControllerUnderTest.savewcQuestion(quest);

        // Verify the results
        assertEquals("WC/id", result);
    }

    @Test
    void testGetWcQuestion() {
        // Setup

        // Configure OpenEndedRepository.findById(...).
        final OpenEnded openEnded1 = new OpenEnded();
        openEnded1.setId("id");
        openEnded1.setQuestion("question");
        openEnded1.setBg(new Background(20,"blue","black"));

        final Optional<OpenEnded> openEnded = Optional.of(openEnded1);
        when(mockOpenEndedRepository.findById("id")).thenReturn(openEnded);

        // Run the test
        final OpenEnded result = openEndedControllerUnderTest.getWcQuestion("id");

      
    }


    @Test
    void testGetAllQandA() {
        // Setup

        // Configure OpenEndedRepository.findAll(...).
        final OpenEnded openEnded = new OpenEnded();
        openEnded.setId("id");
        openEnded.setQuestion("question");
        openEnded.setBg(new Background(20,"blue","black"));

        final List<OpenEnded> openEndeds = Arrays.asList(openEnded);
        when(mockOpenEndedRepository.findAll()).thenReturn(openEndeds);

        // Run the test
        final List<OpenEnded> result = openEndedControllerUnderTest.getAllQandA();

    
    }

    @Test
    void testGetAllQandA_OpenEndedRepositoryReturnsNoItems() {
        // Setup
        when(mockOpenEndedRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<OpenEnded> result = openEndedControllerUnderTest.getAllQandA();

        // Verify the results
    }

    @Test
    void testSaveQandAQuestion() {
        // Setup
        final OpenEnded quest = new OpenEnded();
        quest.setId("id");
        quest.setQuestion("question");
        quest.setBg(new Background(20,"blue","black"));


        // Configure OpenEndedRepository.save(...).
        final OpenEnded openEnded = new OpenEnded();
        openEnded.setId("id");
        openEnded.setQuestion("question");
        openEnded.setBg(new Background(20,"blue","black"));

        when(mockOpenEndedRepository.save(any(OpenEnded.class))).thenReturn(openEnded);

        // Run the test
        final String result = openEndedControllerUnderTest.saveQandAQuestion(quest);

        // Verify the results
        assertEquals("QandA/id", result);
    }

    @Test
    void testGetQandAquestion() {
        // Setup

        // Configure OpenEndedRepository.findById(...).
        final OpenEnded openEnded1 = new OpenEnded();
        openEnded1.setId("id");
        openEnded1.setQuestion("question");
        openEnded1.setBg(new Background(20,"blue","black"));

        final Optional<OpenEnded> openEnded = Optional.of(openEnded1);
        when(mockOpenEndedRepository.findById("id")).thenReturn(openEnded);

        // Run the test
        final OpenEnded result = openEndedControllerUnderTest.getQandAquestion("id");

    }


}
