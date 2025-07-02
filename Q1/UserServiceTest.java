package com.example.service;

import com.example.model.User;
import com.example.repo.UserRepository;
import com.example.util.EmailSender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository userRepository;
    @Mock
    EmailSender emailSender;
    @InjectMocks
    UserService userService;
    @Test
    void testUserServiceProcessUser() {
        User user = new User("u123", "Shreyash", "shreyash@gmail.com");
        when(userRepository.findById("u123")).thenReturn(null, user);
        assertThrows(RuntimeException.class, () -> userService.processUser("u123"));
        userService.processUser("u123");
        ArgumentCaptor<String> subjectCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> emailCaptor = ArgumentCaptor.forClass(String.class);
        verify(emailSender).send(subjectCaptor.capture(), emailCaptor.capture());
        assertEquals("Welcome Shreyash", subjectCaptor.getValue());
        assertEquals("shreyash@example.com", emailCaptor.getValue());
    }
}
