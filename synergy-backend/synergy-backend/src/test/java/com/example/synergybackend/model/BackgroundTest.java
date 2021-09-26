package com.example.synergybackend.model;

import org.junit.jupiter.api.BeforeEach;

class BackgroundTest {

    private Background backgroundUnderTest;

    @BeforeEach
    void setUp() {
        backgroundUnderTest = new Background(0, "bgColor", "textColor");
    }
}
