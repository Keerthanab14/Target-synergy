package com.synergy.responses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

class ResponsesApplicationTest {

    private ResponsesApplication responsesApplicationUnderTest;

    @BeforeEach
    void setUp() {
        responsesApplicationUnderTest = new ResponsesApplication();
    }

    @Test
    void testCorsConfigurer() {
        // Setup

        // Run the test
        final WebMvcConfigurer result = responsesApplicationUnderTest.corsConfigurer();

        // Verify the results
    }

    @Test
    void testMain() {
        // Setup

        // Run the test
        ResponsesApplication.main(new String[]{"value"});

        // Verify the results
    }
}
