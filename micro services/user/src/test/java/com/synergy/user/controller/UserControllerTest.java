package com.synergy.user.controller;

import com.synergy.user.model.User;
import com.synergy.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
    void testGetUser() {
        // Setup

        // Configure UserRepository.findById(...).
        MockitoAnnotations.openMocks(this);

        final User user1 = new User();
        user1.setGoogleId("googleId");
        user1.setEmail("email");
        user1.setName("name");
        final Optional<User> user = Optional.of(user1);
        when(mockUserRepository.findById("id")).thenReturn(user);

        // Run the test
        final Optional<User> result = userControllerUnderTest.getUser("id");

        // Verify the results
    }

    @Test
    void testGetUser_UserRepositoryReturnsAbsent() {
        // Setup
        MockitoAnnotations.openMocks(this);

        when(mockUserRepository.findById("id")).thenReturn(Optional.empty());

        // Run the test
        final Optional<User> result = userControllerUnderTest.getUser("id");

        // Verify the results
    }

    @Test
    void testSaveUser() {
        // Setup
        MockitoAnnotations.openMocks(this);

        final Map<String, Object> user = new HashMap<>();

        // Configure UserRepository.save(...).
        final User user1 = new User();
        user1.setGoogleId("googleId");
        user1.setEmail("email");
        user1.setName("name");
        when(mockUserRepository.save(any(User.class))).thenReturn(user1);
        user.put("googleId","123");
        user.put("email","abc@xyz");
        user.put("name","abc");
        user.put("data","success");

        // Run the test
        final String result = userControllerUnderTest.saveUser(user);

        // Verify the results
       // assertEquals("result", result);
        System.out.print(result);
        verify(mockUserRepository).save(any(User.class));
    }
}
