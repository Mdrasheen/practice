package com.rasheen.practice.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getMessage() {
        return "Spring Boot with Service Layer 💡";
    }
}

