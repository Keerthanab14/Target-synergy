package com.example.synergybackend.controller;

import com.example.synergybackend.model.User;
import com.example.synergybackend.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class UserControllerTest {

    @Mock
    private UserService mockUserService;

    @InjectMocks
    private UserController userControllerUnderTest;

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
    void testGetAllUser() {
        // Setup

        // Configure UserService.getAllUser(...).
        final User user = new User();
        user.setGoogleId("googleId");
        user.setEmail("email");
        user.setName("name");
        final List<User> users = List.of(user);
        when(mockUserService.getAllUser()).thenReturn(users);

        // Run the test
        final List<User> result = userControllerUnderTest.getAllUser();

        // Verify the results
    }


    @Test
    void testGetUser() {
        // Setup

        // Configure UserService.getUser(...).
        final User user = new User();
        user.setGoogleId("googleId");
        user.setEmail("email");
        user.setName("name");
        when(mockUserService.getUser("googleId")).thenReturn(user);

        // Run the test
        final User result = userControllerUnderTest.getUser("googleId");

        // Verify the results
    }

    @Test
    void testSaveUser() {
        // Setup
        final User user = new User();
        user.setGoogleId("googleId");
        user.setEmail("email");
        user.setName("name");

        when(mockUserService.saveUser(any(User.class))).thenReturn("result");

        // Run the test
        final String result = userControllerUnderTest.saveUser(user);

        // Verify the results
        assertThat(result).isEqualTo("result");
    }
}
