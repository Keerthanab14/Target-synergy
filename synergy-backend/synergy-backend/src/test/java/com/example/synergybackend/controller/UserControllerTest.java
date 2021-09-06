package com.example.synergybackend.controller;

import com.example.synergybackend.model.User;
import com.example.synergybackend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserController userControllerUnderTest;

    @Test
    void testGetAllUser() {
        // Setup

        // Configure UserRepository.findAll(...).
        final User user = new User();
        user.setGoogleId("googleId");
        user.setEmail("email");
        user.setName("name");
        final List<User> users = Arrays.asList(user);
        when(mockUserRepository.findAll()).thenReturn(users);

        // Run the test
        final List<User> result = userControllerUnderTest.getAllUser();

        // Verify the results
    }

    @Test
    void testGetAllUser_UserRepositoryReturnsNoItems() {
        // Setup
        when(mockUserRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<User> result = userControllerUnderTest.getAllUser();

        // Verify the results
    }


}
