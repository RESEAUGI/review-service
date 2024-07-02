package com.review.service;

import org.apache.pulsar.shade.com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final ObjectMapper objectMapper;


    public UserService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
