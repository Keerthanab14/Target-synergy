package com.example.synergybackend.model;

import org.junit.jupiter.api.BeforeEach;

class ChoiceTest {

    private Choice choiceUnderTest;

    @BeforeEach
    void setUp() {
        choiceUnderTest = new Choice("option", 0);
    }
}
