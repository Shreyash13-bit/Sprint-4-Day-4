package com.example.service;

import com.example.repo.UserRepository;
import com.example.util.EmailSender;
import com.example.model.User;

public class UserService {
    private final UserRepository userRepository;
    private final EmailSender emailSender;

    public UserService(UserRepository userRepository, EmailSender emailSender) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    public void processUser(String userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            handleMissingUser(userId);
            throw new RuntimeException("User not found");
        }
        emailSender.send("Welcome " + user.getName(), user.getEmail());
    }

    public void handleMissingUser(String userId) {
        System.out.println("Fallback logic for missing user: " + userId);
    }
}
