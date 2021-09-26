package com.example.synergybackend.controller;

import com.example.synergybackend.model.Responses;
import com.example.synergybackend.service.ResponsesService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class ResponsesControllerTest {

    @Mock
    private ResponsesService mockResponsesService;

    @InjectMocks
    private ResponsesController responsesControllerUnderTest;

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
    void testGetAllResponses() {
        // Setup

        // Configure ResponsesService.getAllResponses(...).
        final Responses responses1 = new Responses();
        responses1.setId("id");
        responses1.setResponses(new ArrayList<>(List.of("value")));
        responses1.setQuestion("question");
        final List<Responses> responses = List.of(responses1);
        when(mockResponsesService.getAllResponses()).thenReturn(responses);

        // Run the test
        final List<Responses> result = responsesControllerUnderTest.getAllResponses();

        // Verify the results
    }


    @Test
    void testGetResponsesById() {
        // Setup

        // Configure ResponsesService.getResponsesById(...).
        final Responses responses = new Responses();
        responses.setId("id");
        responses.setResponses(new ArrayList<>(List.of("value")));
        responses.setQuestion("question");
        when(mockResponsesService.getResponsesById("id")).thenReturn(responses);

        // Run the test
        final Responses result = responsesControllerUnderTest.getResponsesById("id");

        // Verify the results
    }

    @Test
    void testGetQuestionById() {
        // Setup
        when(mockResponsesService.getQuestionById("id")).thenReturn("result");

        // Run the test
        final String result = responsesControllerUnderTest.getQuestionById("id");

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    void testSaveNewResponses() {
        // Setup
        final Responses quest = new Responses();
        quest.setId("id");
        quest.setResponses(new ArrayList<>(List.of("value")));
        quest.setQuestion("question");

        when(mockResponsesService.saveNewResponses(any(Responses.class))).thenReturn("result");

        // Run the test
        final String result = responsesControllerUnderTest.saveNewResponses(quest);

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    void testSaveResponses() {
        // Setup
        final Responses quest = new Responses();
        quest.setId("id");
        quest.setResponses(new ArrayList<>(List.of("value")));
        quest.setQuestion("question");

        when(mockResponsesService.saveResponses(any(Responses.class), eq("id"))).thenReturn("result");
        when(mockResponsesService.saveNewResponses(any(Responses.class))).thenReturn("result");

        // Run the test
        final String result = responsesControllerUnderTest.saveResponses(quest, "id");

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    void testGetquestionsById() {
        // Setup
        when(mockResponsesService.getWCResponse("id")).thenReturn(Map.ofEntries());

        // Run the test
        final Map result = responsesControllerUnderTest.getquestionsById("id");

        // Verify the results
    }

    @Test
    void testSaveNewWcResponses() {
        // Setup
        final Responses quest = new Responses();
        quest.setId("id");
        quest.setResponses(new ArrayList<>(List.of("value")));
        quest.setQuestion("question");

        when(mockResponsesService.saveNewWcResponses(any(Responses.class))).thenReturn("result");

        // Run the test
        final String result = responsesControllerUnderTest.saveNewWcResponses(quest);

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    void testSaveWCResponses() {
        // Setup
        final Responses quest = new Responses();
        quest.setId("id");
        quest.setResponses(new ArrayList<>(List.of("value")));
        quest.setQuestion("question");

        when(mockResponsesService.saveWCResponses(any(Responses.class), eq("id"))).thenReturn("result");
        when(mockResponsesService.saveNewWcResponses(any(Responses.class))).thenReturn("result");

        // Run the test
        final String result = responsesControllerUnderTest.saveWCResponses(quest, "id");

        // Verify the results
        assertThat(result).isEqualTo("result");
    }
}
