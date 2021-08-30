package com.synergy.openEnded;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

class OpenEndedApplicationTest {

    private OpenEndedApplication openEndedApplicationUnderTest;

    @BeforeEach
    void setUp() {
        openEndedApplicationUnderTest = new OpenEndedApplication();
    }

    @Test
    void testCorsConfigurer() {
        // Setup

        // Run the test
        final WebMvcConfigurer result = openEndedApplicationUnderTest.corsConfigurer();

        // Verify the results
    }

    @Test
    void testMain() {
        // Setup

        // Run the test
        OpenEndedApplication.main(new String[]{"value"});

        // Verify the results
    }
}
