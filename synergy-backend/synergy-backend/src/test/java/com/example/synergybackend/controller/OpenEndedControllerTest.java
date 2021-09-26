package com.example.synergybackend.controller;

import com.example.synergybackend.model.Background;
import com.example.synergybackend.model.OpenEnded;
import com.example.synergybackend.service.OpenEndedService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class OpenEndedControllerTest {

    @Mock
    private OpenEndedService mockOpenEndedService;

    @InjectMocks
    private OpenEndedController openEndedControllerUnderTest;

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
    void testGetByUser() {
        // Setup

        // Configure OpenEndedService.getByUser(...).
        final OpenEnded openEnded = new OpenEnded();
        openEnded.setBg(new Background(0, "bgColor", "textColor"));
        openEnded.setType("type");
        openEnded.setGoogleId("googleId");
        openEnded.setId("id");
        openEnded.setQuestion("question");
        final List<OpenEnded> openEnds = List.of(openEnded);
        when(mockOpenEndedService.getByUser("id")).thenReturn(openEnds);

        // Run the test
        final List<OpenEnded> result = openEndedControllerUnderTest.getByUser("id");

        // Verify the results
    }


    @Test
    void testGetAllquestion() {
        // Setup

        // Configure OpenEndedService.getAllquestion(...).
        final OpenEnded openEnded = new OpenEnded();
        openEnded.setBg(new Background(0, "bgColor", "textColor"));
        openEnded.setType("type");
        openEnded.setGoogleId("googleId");
        openEnded.setId("id");
        openEnded.setQuestion("question");
        final List<OpenEnded> openEndeds = List.of(openEnded);
        when(mockOpenEndedService.getAllquestion()).thenReturn(openEndeds);

        // Run the test
        final List<OpenEnded> result = openEndedControllerUnderTest.getAllquestion();

        // Verify the results
    }

    @Test
    void testSaveQuestion() {
        // Setup
        final OpenEnded quest = new OpenEnded();
        quest.setBg(new Background(0, "bgColor", "textColor"));
        quest.setType("type");
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");

        when(mockOpenEndedService.saveQuestion(any(OpenEnded.class))).thenReturn("result");

        // Run the test
        final String result = openEndedControllerUnderTest.saveQuestion(quest);

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    void testSaveWithBg() {
        // Setup
        final Background quest = new Background(0, "bgColor", "textColor");
        when(mockOpenEndedService.saveWithBg(eq("id"), any(Background.class))).thenReturn("result");

        // Run the test
        final String result = openEndedControllerUnderTest.saveWithBg("id", quest);

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    void testGetOpenEndedquestion() {
        // Setup

        // Configure OpenEndedService.getOpenEndedquestion(...).
        final OpenEnded openEnded = new OpenEnded();
        openEnded.setBg(new Background(0, "bgColor", "textColor"));
        openEnded.setType("type");
        openEnded.setGoogleId("googleId");
        openEnded.setId("id");
        openEnded.setQuestion("question");
        when(mockOpenEndedService.getOpenEndedquestion("id")).thenReturn(openEnded);

        // Run the test
        final OpenEnded result = openEndedControllerUnderTest.getOpenEndedquestion("id");

        // Verify the results
    }

    @Test
    void testSavewcQuestion() {
        // Setup
        final OpenEnded quest = new OpenEnded();
        quest.setBg(new Background(0, "bgColor", "textColor"));
        quest.setType("type");
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");

        when(mockOpenEndedService.savewcQuestion(any(OpenEnded.class))).thenReturn("result");

        // Run the test
        final String result = openEndedControllerUnderTest.savewcQuestion(quest);

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    void testGetWcQuestion() {
        // Setup

        // Configure OpenEndedService.getWcQuestion(...).
        final OpenEnded openEnded = new OpenEnded();
        openEnded.setBg(new Background(0, "bgColor", "textColor"));
        openEnded.setType("type");
        openEnded.setGoogleId("googleId");
        openEnded.setId("id");
        openEnded.setQuestion("question");
        when(mockOpenEndedService.getWcQuestion("id")).thenReturn(openEnded);

        // Run the test
        final OpenEnded result = openEndedControllerUnderTest.getWcQuestion("id");

        // Verify the results
    }

    @Test
    void testSaveWCBg() {
        // Setup
        final Background quest = new Background(0, "bgColor", "textColor");
        when(mockOpenEndedService.saveWCBg(eq("id"), any(Background.class))).thenReturn("result");

        // Run the test
        final String result = openEndedControllerUnderTest.saveWCBg("id", quest);

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    void testGetAllQandA() {
        // Setup

        // Configure OpenEndedService.getAllQandA(...).
        final OpenEnded openEnded = new OpenEnded();
        openEnded.setBg(new Background(0, "bgColor", "textColor"));
        openEnded.setType("type");
        openEnded.setGoogleId("googleId");
        openEnded.setId("id");
        openEnded.setQuestion("question");
        final List<OpenEnded> openEndeds = List.of(openEnded);
        when(mockOpenEndedService.getAllQandA()).thenReturn(openEndeds);

        // Run the test
        final List<OpenEnded> result = openEndedControllerUnderTest.getAllQandA();

        // Verify the results
    }

    @Test
    void testSaveQandAQuestion() {
        // Setup
        final OpenEnded quest = new OpenEnded();
        quest.setBg(new Background(0, "bgColor", "textColor"));
        quest.setType("type");
        quest.setGoogleId("googleId");
        quest.setId("id");
        quest.setQuestion("question");

        when(mockOpenEndedService.saveQandAQuestion(any(OpenEnded.class))).thenReturn("result");

        // Run the test
        final String result = openEndedControllerUnderTest.saveQandAQuestion(quest);

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    void testGetQandAquestion() {
        // Setup

        // Configure OpenEndedService.getQandAquestion(...).
        final OpenEnded openEnded = new OpenEnded();
        openEnded.setBg(new Background(0, "bgColor", "textColor"));
        openEnded.setType("type");
        openEnded.setGoogleId("googleId");
        openEnded.setId("id");
        openEnded.setQuestion("question");
        when(mockOpenEndedService.getQandAquestion("id")).thenReturn(openEnded);

        // Run the test
        final OpenEnded result = openEndedControllerUnderTest.getQandAquestion("id");

        // Verify the results
    }

    @Test
    void testSaveBg() {
        // Setup
        final Background quest = new Background(0, "bgColor", "textColor");
        when(mockOpenEndedService.saveBg(eq("id"), any(Background.class))).thenReturn("result");

        // Run the test
        final String result = openEndedControllerUnderTest.saveBg("id", quest);

        // Verify the results
        assertThat(result).isEqualTo("result");
    }
}
