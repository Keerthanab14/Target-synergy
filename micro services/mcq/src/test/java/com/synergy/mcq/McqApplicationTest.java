package com.synergy.mcq;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

class McqApplicationTest {

    private McqApplication mcqApplicationUnderTest;

    @BeforeEach
    void setUp() {
        mcqApplicationUnderTest = new McqApplication();
    }

    @Test
    void testCorsConfigurer() {
        // Setup

        // Run the test
        final WebMvcConfigurer result = mcqApplicationUnderTest.corsConfigurer();

        // Verify the results
    }

    @Test
    void testMain() {
        // Setup

        // Run the test
        McqApplication.main(new String[]{"value"});

        // Verify the results
    }
}
