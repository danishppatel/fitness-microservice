package com.fitness.service;

import com.fitness.dto.RegisterRequest;
import com.fitness.dto.UserResponse;
import com.fitness.model.User;

public interface UserService {
    UserResponse getUserProfile(String userId);
    UserResponse register(RegisterRequest request);
    Boolean existsUserByEmail(String email);
}
