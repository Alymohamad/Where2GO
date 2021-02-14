package com.example.springboot.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ApiKeyUtil {

    public static ApiKeyUtil instance;

    @Value("${api_key}")
    private String apiKey;

    @PostConstruct
    public void init() {
        instance = this;
    }

    public String getApiKey() {
        return apiKey;
    }

    public static ApiKeyUtil getInstance() {
        return instance;
    }
}