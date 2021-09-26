package com.example.synergybackend.service;

import com.example.synergybackend.model.Background;
import com.example.synergybackend.model.OpenEnded;
import com.example.synergybackend.repository.OpenEndedRepository;
import com.example.synergybackend.service.OpenEndedService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class OpenEndedServiceTest {

    @Mock
    private OpenEndedRepository mockOpenEndedRepository;

    @InjectMocks
    private OpenEndedService openEndedServiceUnderTest;

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

        // Configure OpenEndedRepository.findAllByGoogleId(...).
        final OpenEnded openEnded = new OpenEnded();
        openEnded.setBg(new Background(0, "bgColor", "textColor"));
        openEnded.setType("type");
        openEnded.setGoogleId("googleId");
        openEnded.setId("id");
        openEnded.setQuestion("question");
        final List<OpenEnded> openEndeds = List.of(openEnded);
        when(mockOpenEndedRepository.findAllByGoogleId("id")).thenReturn(openEndeds);

        // Run the test
        final List<OpenEnded> result = openEndedServiceUnderTest.getByUser("id");

        // Verify the results
    }


    @Test
    void testGetAllquestion() {
        // Setup

        // Configure OpenEndedRepository.findAll(...).
        final OpenEnded openEnded = new OpenEnded();
        openEnded.setBg(new Background(0, "bgColor", "textColor"));
        openEnded.setType("type");
        openEnded.setGoogleId("googleId");
        openEnded.setId("id");
        openEnded.setQuestion("question");
        final List<OpenEnded> openEndeds = List.of(openEnded);
        when(mockOpenEndedRepository.findAll()).thenReturn(openEndeds);

        // Run the test
        final List<OpenEnded> result = openEndedServiceUnderTest.getAllquestion();

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

        // Configure OpenEndedRepository.save(...).
        final OpenEnded openEnded = new OpenEnded();
        openEnded.setBg(new Background(0, "bgColor", "textColor"));
        openEnded.setType("type");
        openEnded.setGoogleId("googleId");
        openEnded.setId("id");
        openEnded.setQuestion("question");
        when(mockOpenEndedRepository.save(any(OpenEnded.class))).thenReturn(openEnded);

        // Run the test
        final String result = openEndedServiceUnderTest.saveQuestion(quest);

        // Verify the results
        assertThat(result).isEqualTo("OE/id");
    }

    @Test
    void testSaveWithBg() {
        // Setup
        final Background quest = new Background(0, "bgColor", "textColor");

        // Configure OpenEndedRepository.findById(...).
        final OpenEnded openEnded1 = new OpenEnded();
        openEnded1.setBg(new Background(0, "bgColor", "textColor"));
        openEnded1.setType("type");
        openEnded1.setGoogleId("googleId");
        openEnded1.setId("id");
        openEnded1.setQuestion("question");
        final Optional<OpenEnded> openEnded = Optional.of(openEnded1);
        when(mockOpenEndedRepository.findById("id")).thenReturn(openEnded);

        // Configure OpenEndedRepository.save(...).
        final OpenEnded openEnded2 = new OpenEnded();
        openEnded2.setBg(new Background(0, "bgColor", "textColor"));
        openEnded2.setType("type");
        openEnded2.setGoogleId("googleId");
        openEnded2.setId("id");
        openEnded2.setQuestion("question");
        when(mockOpenEndedRepository.save(any(OpenEnded.class))).thenReturn(openEnded2);

        // Run the test
        final String result = openEndedServiceUnderTest.saveWithBg("id", quest);

        // Verify the results
        assertThat(result).isEqualTo("OE/id");
    }

    @Test
    void testGetOpenEndedquestion() {
        // Setup

        // Configure OpenEndedRepository.findById(...).
        final OpenEnded openEnded1 = new OpenEnded();
        openEnded1.setBg(new Background(0, "bgColor", "textColor"));
        openEnded1.setType("type");
        openEnded1.setGoogleId("googleId");
        openEnded1.setId("id");
        openEnded1.setQuestion("question");
        final Optional<OpenEnded> openEnded = Optional.of(openEnded1);
        when(mockOpenEndedRepository.findById("id")).thenReturn(openEnded);

        // Run the test
        final OpenEnded result = openEndedServiceUnderTest.getOpenEndedquestion("id");

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

        // Configure OpenEndedRepository.save(...).
        final OpenEnded openEnded = new OpenEnded();
        openEnded.setBg(new Background(0, "bgColor", "textColor"));
        openEnded.setType("type");
        openEnded.setGoogleId("googleId");
        openEnded.setId("id");
        openEnded.setQuestion("question");
        when(mockOpenEndedRepository.save(any(OpenEnded.class))).thenReturn(openEnded);

        // Run the test
        final String result = openEndedServiceUnderTest.savewcQuestion(quest);

        // Verify the results
        assertThat(result).isEqualTo("WC/id");
    }

    @Test
    void testGetWcQuestion() {
        // Setup

        // Configure OpenEndedRepository.findById(...).
        final OpenEnded openEnded1 = new OpenEnded();
        openEnded1.setBg(new Background(0, "bgColor", "textColor"));
        openEnded1.setType("type");
        openEnded1.setGoogleId("googleId");
        openEnded1.setId("id");
        openEnded1.setQuestion("question");
        final Optional<OpenEnded> openEnded = Optional.of(openEnded1);
        when(mockOpenEndedRepository.findById("id")).thenReturn(openEnded);

        // Run the test
        final OpenEnded result = openEndedServiceUnderTest.getWcQuestion("id");

        // Verify the results
    }

    @Test
    void testSaveWCBg() {
        // Setup
        final Background quest = new Background(0, "bgColor", "textColor");

        // Configure OpenEndedRepository.findById(...).
        final OpenEnded openEnded1 = new OpenEnded();
        openEnded1.setBg(new Background(0, "bgColor", "textColor"));
        openEnded1.setType("type");
        openEnded1.setGoogleId("googleId");
        openEnded1.setId("id");
        openEnded1.setQuestion("question");
        final Optional<OpenEnded> openEnded = Optional.of(openEnded1);
        when(mockOpenEndedRepository.findById("id")).thenReturn(openEnded);

        // Configure OpenEndedRepository.save(...).
        final OpenEnded openEnded2 = new OpenEnded();
        openEnded2.setBg(new Background(0, "bgColor", "textColor"));
        openEnded2.setType("type");
        openEnded2.setGoogleId("googleId");
        openEnded2.setId("id");
        openEnded2.setQuestion("question");
        when(mockOpenEndedRepository.save(any(OpenEnded.class))).thenReturn(openEnded2);

        // Run the test
        final String result = openEndedServiceUnderTest.saveWCBg("id", quest);

        // Verify the results
        assertThat(result).isEqualTo("WC/id");
    }

    @Test
    void testGetAllQandA() {
        // Setup

        // Configure OpenEndedRepository.findAll(...).
        final OpenEnded openEnded = new OpenEnded();
        openEnded.setBg(new Background(0, "bgColor", "textColor"));
        openEnded.setType("type");
        openEnded.setGoogleId("googleId");
        openEnded.setId("id");
        openEnded.setQuestion("question");
        final List<OpenEnded> openEndeds = List.of(openEnded);
        when(mockOpenEndedRepository.findAll()).thenReturn(openEndeds);

        // Run the test
        final List<OpenEnded> result = openEndedServiceUnderTest.getAllQandA();

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

        // Configure OpenEndedRepository.save(...).
        final OpenEnded openEnded = new OpenEnded();
        openEnded.setBg(new Background(0, "bgColor", "textColor"));
        openEnded.setType("type");
        openEnded.setGoogleId("googleId");
        openEnded.setId("id");
        openEnded.setQuestion("question");
        when(mockOpenEndedRepository.save(any(OpenEnded.class))).thenReturn(openEnded);

        // Run the test
        final String result = openEndedServiceUnderTest.saveQandAQuestion(quest);

        // Verify the results
        assertThat(result).isEqualTo("QandA/id");
    }

    @Test
    void testGetQandAquestion() {
        // Setup

        // Configure OpenEndedRepository.findById(...).
        final OpenEnded openEnded1 = new OpenEnded();
        openEnded1.setBg(new Background(0, "bgColor", "textColor"));
        openEnded1.setType("type");
        openEnded1.setGoogleId("googleId");
        openEnded1.setId("id");
        openEnded1.setQuestion("question");
        final Optional<OpenEnded> openEnded = Optional.of(openEnded1);
        when(mockOpenEndedRepository.findById("id")).thenReturn(openEnded);

        // Run the test
        final OpenEnded result = openEndedServiceUnderTest.getQandAquestion("id");

        // Verify the results
    }

    @Test
    void testSaveBg() {
        // Setup
        final Background quest = new Background(0, "bgColor", "textColor");

        // Configure OpenEndedRepository.findById(...).
        final OpenEnded openEnded1 = new OpenEnded();
        openEnded1.setBg(new Background(0, "bgColor", "textColor"));
        openEnded1.setType("type");
        openEnded1.setGoogleId("googleId");
        openEnded1.setId("id");
        openEnded1.setQuestion("question");
        final Optional<OpenEnded> openEnded = Optional.of(openEnded1);
        when(mockOpenEndedRepository.findById("id")).thenReturn(openEnded);

        // Configure OpenEndedRepository.save(...).
        final OpenEnded openEnded2 = new OpenEnded();
        openEnded2.setBg(new Background(0, "bgColor", "textColor"));
        openEnded2.setType("type");
        openEnded2.setGoogleId("googleId");
        openEnded2.setId("id");
        openEnded2.setQuestion("question");
        when(mockOpenEndedRepository.save(any(OpenEnded.class))).thenReturn(openEnded2);

        // Run the test
        final String result = openEndedServiceUnderTest.saveBg("id", quest);

        // Verify the results
        assertThat(result).isEqualTo("QandA/id");
    }

}
