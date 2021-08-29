package com.synergy.responses.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponsesTest {

    private Responses responsesUnderTest;

    @BeforeEach
    void setUp() {
        responsesUnderTest = new Responses();
    }

    @Test
    void testSetLatestAnswer() {
        // Setup

        // Run the test
        final String result = responsesUnderTest.setLatestAnswer("latestAnswer");

        // Verify the results
        assertEquals("latestAnswer", result,"success");
    }
}
