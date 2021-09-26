package com.example.synergybackend.service;

import com.example.synergybackend.model.Responses;
import com.example.synergybackend.repository.ResponsesRepository;
import com.example.synergybackend.service.ResponsesService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class ResponsesServiceTest {

    @Mock
    private ResponsesRepository mockResponsesRepository;

    @InjectMocks
    private ResponsesService responsesServiceUnderTest;

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

        // Configure ResponsesRepository.findAll(...).
        final Responses responses1 = new Responses();
        responses1.setId("id");
        responses1.setResponses(new ArrayList<>(List.of("value")));
        responses1.setQuestion("question");
        final List<Responses> responses = List.of(responses1);
        when(mockResponsesRepository.findAll()).thenReturn(responses);

        // Run the test
        final List<Responses> result = responsesServiceUnderTest.getAllResponses();

        // Verify the results
    }


    @Test
    void testGetResponsesById() {
        // Setup

        // Configure ResponsesRepository.findById(...).
        final Responses responses1 = new Responses();
        responses1.setId("id");
        responses1.setResponses(new ArrayList<>(List.of("value")));
        responses1.setQuestion("question");
        final Optional<Responses> responses = Optional.of(responses1);
        when(mockResponsesRepository.findById("id")).thenReturn(responses);

        // Run the test
        final Responses result = responsesServiceUnderTest.getResponsesById("id");

        // Verify the results
    }

    @Test
    void testGetQuestionById() {
        // Setup

        // Configure ResponsesRepository.findByQuestion(...).
        final Responses responses = new Responses();
        responses.setId("id");
        responses.setResponses(new ArrayList<>(List.of("value")));
        responses.setQuestion("question");
        when(mockResponsesRepository.findByQuestion("id")).thenReturn(responses);

        // Run the test
        final String result = responsesServiceUnderTest.getQuestionById("id");

        // Verify the results
        assertThat(result).isEqualTo("id");
    }

    @Test
    void testSaveNewResponses() {
        // Setup
        final Responses quest = new Responses();
        quest.setId("id");
        quest.setResponses(new ArrayList<>(List.of("value")));
        quest.setQuestion("question");

        // Configure ResponsesRepository.save(...).
        final Responses responses = new Responses();
        responses.setId("id");
        responses.setResponses(new ArrayList<>(List.of("value")));
        responses.setQuestion("question");
        when(mockResponsesRepository.save(any(Responses.class))).thenReturn(responses);

        // Run the test
        final String result = responsesServiceUnderTest.saveNewResponses(quest);

        // Verify the results
        assertThat(result).isEqualTo("responses/id");
    }

    @Test
    void testSaveResponses() {
        // Setup
        final Responses quest = new Responses();
        quest.setId("id");
        quest.setResponses(new ArrayList<>(List.of("value")));
        quest.setQuestion("question");

        // Configure ResponsesRepository.findById(...).
        final Responses responses1 = new Responses();
        responses1.setId("id");
        responses1.setResponses(new ArrayList<>(List.of("value")));
        responses1.setQuestion("question");
        final Optional<Responses> responses = Optional.of(responses1);
        when(mockResponsesRepository.findById("id")).thenReturn(responses);

        // Configure ResponsesRepository.save(...).
        final Responses responses2 = new Responses();
        responses2.setId("id");
        responses2.setResponses(new ArrayList<>(List.of("value")));
        responses2.setQuestion("question");
        when(mockResponsesRepository.save(any(Responses.class))).thenReturn(responses2);

        // Run the test
        final String result = responsesServiceUnderTest.saveResponses(quest, "id");

        // Verify the results
        assertThat(result).isEqualTo("responses/id");
    }

    @Test
    void testSaveNewWcResponses() {
        // Setup
        final Responses quest = new Responses();
        quest.setId("id");
        quest.setResponses(new ArrayList<>(List.of("value")));
        quest.setQuestion("question");

        // Configure ResponsesRepository.save(...).
        final Responses responses = new Responses();
        responses.setId("id");
        responses.setResponses(new ArrayList<>(List.of("value")));
        responses.setQuestion("question");
        when(mockResponsesRepository.save(any(Responses.class))).thenReturn(responses);

        // Run the test
        final String result = responsesServiceUnderTest.saveNewWcResponses(quest);

        // Verify the results
        assertThat(result).isEqualTo("WC/id");
    }

    @Test
    void testGetWCResponse() {
        // Setup

        // Configure ResponsesRepository.findById(...).
        final Responses responses1 = new Responses();
        responses1.setId("id");
        responses1.setResponses(new ArrayList<>(List.of("value")));
        responses1.setQuestion("question");
        final Optional<Responses> responses = Optional.of(responses1);
        when(mockResponsesRepository.findById("id")).thenReturn(responses);

        // Run the test
        final Map result = responsesServiceUnderTest.getWCResponse("id");

        // Verify the results
    }

    @Test
    void testSaveWCResponses() {
        // Setup
        final Responses quest = new Responses();
        quest.setId("id");
        quest.setResponses(new ArrayList<>(List.of("value")));
        quest.setQuestion("question");

        // Configure ResponsesRepository.findById(...).
        final Responses responses1 = new Responses();
        responses1.setId("id");
        responses1.setResponses(new ArrayList<>(List.of("value")));
        responses1.setQuestion("question");
        final Optional<Responses> responses = Optional.of(responses1);
        when(mockResponsesRepository.findById("id")).thenReturn(responses);

        // Configure ResponsesRepository.save(...).
        final Responses responses2 = new Responses();
        responses2.setId("id");
        responses2.setResponses(new ArrayList<>(List.of("value")));
        responses2.setQuestion("question");
        when(mockResponsesRepository.save(any(Responses.class))).thenReturn(responses2);

        // Run the test
        final String result = responsesServiceUnderTest.saveWCResponses(quest, "id");

        // Verify the results
        assertThat(result).isEqualTo("WC/id");
    }
}
