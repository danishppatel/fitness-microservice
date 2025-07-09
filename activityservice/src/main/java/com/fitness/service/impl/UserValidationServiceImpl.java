package com.fitness.service.impl;

import com.fitness.service.UserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor
public class UserValidationServiceImpl implements UserValidationService {

    private final WebClient userServiceWebClient;

    @Override
    public boolean validationUser(String userId) {
        try{
            return userServiceWebClient.get()
                    .uri("/api/users/{userId}/validate", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();

        }catch (WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.NOT_FOUND){
                throw new RuntimeException("User Not found with id: "+ userId);
            }else if(e.getStatusCode() == HttpStatus.BAD_REQUEST){
                throw new RuntimeException("Invalid User Request.");
            }
        }
        return false;
    }
}
