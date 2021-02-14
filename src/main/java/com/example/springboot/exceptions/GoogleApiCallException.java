package com.example.springboot.exceptions;

public class GoogleApiCallException extends Throwable {
    public GoogleApiCallException(String errorMessage) {
        super(errorMessage);
    }
}
