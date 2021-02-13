package com.example.springboot.exceptions;

public class CityNotFoundException extends Throwable {
    public CityNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
