package com.example.controlleradvice;

public class DuplicateIdentityException extends RuntimeException{
    public DuplicateIdentityException(String message) {
        super(message);
    }
}
