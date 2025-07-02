package com.example.repo;

import com.example.model.User;

public interface UserRepository {
    User findById(String userId);
}
