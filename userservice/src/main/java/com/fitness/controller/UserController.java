package com.fitness.controller;

import com.fitness.dto.RegisterRequest;
import com.fitness.dto.UserResponse;
import com.fitness.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserProfile(@PathVariable("userId") String userId){
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid  @RequestBody RegisterRequest request){
        return ResponseEntity.ok(userService.register(request));
    }
}
