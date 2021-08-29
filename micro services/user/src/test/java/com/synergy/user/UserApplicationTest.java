package com.synergy.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

class UserApplicationTest {

    private UserApplication userApplicationUnderTest;

    @BeforeEach
    void setUp() {
        userApplicationUnderTest = new UserApplication();
    }

    @Test
    void testCorsConfigurer() {
        // Setup

        // Run the test
        final WebMvcConfigurer result = userApplicationUnderTest.corsConfigurer();

        // Verify the results
    }

    @Test
    void testMain() {
        // Setup

        // Run the test
        UserApplication.main(new String[]{"value"});

        // Verify the results
    }
}
