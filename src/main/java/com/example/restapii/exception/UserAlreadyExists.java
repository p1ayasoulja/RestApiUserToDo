package com.example.restapii.exception;

public class UserAlreadyExists extends Exception{
    public UserAlreadyExists(String message) {
        super(message);
    }
}
