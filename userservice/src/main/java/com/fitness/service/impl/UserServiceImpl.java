package com.fitness.service.impl;

import com.fitness.dto.RegisterRequest;
import com.fitness.dto.UserResponse;
import com.fitness.mapper.UserMapper;
import com.fitness.model.User;
import com.fitness.repository.UserRepository;
import com.fitness.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponse getUserProfile(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new RuntimeException("User Not Found"));

        return UserMapper.mapToDto(user);
    }

    @Override
    public UserResponse register(RegisterRequest request) {
        if(existsUserByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exist");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        User savedUser = userRepository.save(user);

        return UserMapper.mapToDto(savedUser);
    }

    @Override
    public Boolean existsUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
