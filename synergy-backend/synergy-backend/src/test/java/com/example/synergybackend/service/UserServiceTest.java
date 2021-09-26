package com.example.synergybackend.service;

import com.example.synergybackend.model.User;
import com.example.synergybackend.repository.UserRepository;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserService userServiceUnderTest;

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

        // Configure UserRepository.findAll(...).
        final User user = new User();
        user.setGoogleId("googleId");
        user.setEmail("email");
        user.setName("name");
        final List<User> users = List.of(user);
        when(mockUserRepository.findAll()).thenReturn(users);

        // Run the test
        final List<User> result = userServiceUnderTest.getAllUser();

        // Verify the results
    }

    @Test
    void testGetUser() {
        // Setup

        // Configure UserRepository.findByGoogleId(...).
        final User user = new User();
        user.setGoogleId("googleId");
        user.setEmail("email");
        user.setName("name");
        when(mockUserRepository.findByGoogleId("googleId")).thenReturn(user);

        // Run the test
        final User result = userServiceUnderTest.getUser("googleId");

        // Verify the results
    }

    @Test
    void testSaveUser() {
        // Setup
        final User user = new User();
        user.setGoogleId("googleId");
        user.setEmail("email");
        user.setName("name");

        // Configure UserRepository.save(...).
        final User user1 = new User();
        user1.setGoogleId("googleId");
        user1.setEmail("email");
        user1.setName("name");
        when(mockUserRepository.save(any(User.class))).thenReturn(user1);

        // Run the test
        final String result = userServiceUnderTest.saveUser(user);

        // Verify the results
        assertThat(result).isEqualTo("new user saved");
        verify(mockUserRepository).save(any(User.class));
    }
}
