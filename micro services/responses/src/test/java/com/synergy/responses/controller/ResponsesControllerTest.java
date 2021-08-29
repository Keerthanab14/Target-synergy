package com.synergy.responses.controller;

import com.synergy.responses.model.Responses;
import com.synergy.responses.repository.ResponsesRepository;
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
class ResponsesControllerTest {

    @Mock
    private ResponsesRepository mockResponsesRepository;

    @InjectMocks
    private ResponsesController responsesControllerUnderTest;

    @Test
    void testGetAllResponses() {
        // Setup

        // Configure ResponsesRepository.findAll(...).
        final Responses responses1 = new Responses();
        responses1.setId("id");
        responses1.setResponses(new ArrayList<>(Arrays.asList("value")));
        responses1.setQuestion("question");
        final List<Responses> responses = Arrays.asList(responses1);
        when(mockResponsesRepository.findAll()).thenReturn(responses);

        // Run the test
        final List<Responses> result = responsesControllerUnderTest.getAllResponses();

        // Verify the results
    }

    @Test
    void testGetAllResponses_ResponsesRepositoryReturnsNoItems() {
        // Setup
        when(mockResponsesRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Responses> result = responsesControllerUnderTest.getAllResponses();

        // Verify the results
    }

    @Test
    void testGetResponsesById() {
        // Setup

        // Configure ResponsesRepository.findById(...).
        final Responses responses1 = new Responses();
        responses1.setId("id");
        responses1.setResponses(new ArrayList<>(Arrays.asList("value")));
        responses1.setQuestion("question");
        final Optional<Responses> responses = Optional.of(responses1);
        when(mockResponsesRepository.findById("id")).thenReturn(responses);

        // Run the test
        final Responses result = responsesControllerUnderTest.getResponsesById("id");

        // Verify the results
    }



    @Test
    void testGetQuestionById() {
        // Setup

        // Configure ResponsesRepository.findByQuestion(...).
        final Responses responses = new Responses();
        responses.setId("id");
        responses.setResponses(new ArrayList<>(Arrays.asList("value")));
        responses.setQuestion("question");
        when(mockResponsesRepository.findByQuestion("id")).thenReturn(responses);

        // Run the test
        final String result = responsesControllerUnderTest.getQuestionById("id");

        // Verify the results
        assertEquals("id", result);
    }

    @Test
    void testSaveResponses() {
        // Setup
        final Responses quest = new Responses();
        quest.setId("id");
        quest.setResponses(new ArrayList<>(Arrays.asList("value")));
        quest.setQuestion("question");

        // Configure ResponsesRepository.findById(...).
        final Responses responses1 = new Responses();
        responses1.setId("id");
        responses1.setResponses(new ArrayList<>(Arrays.asList("value")));
        responses1.setQuestion("question");
        final Optional<Responses> responses = Optional.of(responses1);
        when(mockResponsesRepository.findById("id")).thenReturn(responses);

        // Configure ResponsesRepository.save(...).
        final Responses responses2 = new Responses();
        responses2.setId("id");
        responses2.setResponses(new ArrayList<>(Arrays.asList("value")));
        responses2.setQuestion("question");
        when(mockResponsesRepository.save(any(Responses.class))).thenReturn(responses2);

        // Run the test
        final String result = responsesControllerUnderTest.saveResponses(quest, "id");

        // Verify the results
        assertEquals("responses/id", result);
    }

    @Test
    void testSaveNewResponses() {
        // Setup
        final Responses quest = new Responses();
        quest.setId("id");
        quest.setResponses(new ArrayList<>(Arrays.asList("value")));
        quest.setQuestion("question");

        // Configure ResponsesRepository.save(...).
        final Responses responses = new Responses();
        responses.setId("id");
        responses.setResponses(new ArrayList<>(Arrays.asList("value")));
        responses.setQuestion("question");
        when(mockResponsesRepository.save(any(Responses.class))).thenReturn(responses);

        // Run the test
        final String result = responsesControllerUnderTest.saveNewResponses(quest);

        // Verify the results
        assertEquals("responses/id", result);
    }

    @Test
    void testSaveWCResponses() {
        // Setup
        final Responses quest = new Responses();
        quest.setId("id");
        quest.setResponses(new ArrayList<>(Arrays.asList("value")));
        quest.setQuestion("question");

        // Configure ResponsesRepository.findById(...).
        final Responses responses1 = new Responses();
        responses1.setId("id");
        responses1.setResponses(new ArrayList<>(Arrays.asList("value")));
        responses1.setQuestion("question");
        final Optional<Responses> responses = Optional.of(responses1);
        when(mockResponsesRepository.findById("id")).thenReturn(responses);

        // Configure ResponsesRepository.save(...).
        final Responses responses2 = new Responses();
        responses2.setId("id");
        responses2.setResponses(new ArrayList<>(Arrays.asList("value")));
        responses2.setQuestion("question");
        when(mockResponsesRepository.save(any(Responses.class))).thenReturn(responses2);

        // Run the test
        final String result = responsesControllerUnderTest.saveWCResponses(quest, "id");

        // Verify the results
        assertEquals("WC/id", result);
    }

    @Test
    void testSaveNewWcResponses() {
        // Setup
        final Responses quest = new Responses();
        quest.setId("id");
        quest.setResponses(new ArrayList<>(Arrays.asList("value")));
        quest.setQuestion("question");

        // Configure ResponsesRepository.save(...).
        final Responses responses = new Responses();
        responses.setId("id");
        responses.setResponses(new ArrayList<>(Arrays.asList("value")));
        responses.setQuestion("question");
        when(mockResponsesRepository.save(any(Responses.class))).thenReturn(responses);

        // Run the test
        final String result = responsesControllerUnderTest.saveNewWcResponses(quest);

        // Verify the results
        assertEquals("WC/id", result);
    }

    @Test
    void testGetquestionsById() {
        // Setup

        // Configure ResponsesRepository.findById(...).
        final Responses responses1 = new Responses();
        responses1.setId("id");
        responses1.setResponses(new ArrayList<>(Arrays.asList("value")));
        responses1.setQuestion("question");
        final Optional<Responses> responses = Optional.of(responses1);
        when(mockResponsesRepository.findById("id")).thenReturn(responses);

        // Run the test
        final Map result = responsesControllerUnderTest.getquestionsById("id");

        // Verify the results
    }


}
