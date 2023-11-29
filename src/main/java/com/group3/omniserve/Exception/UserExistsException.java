package com.group3.omniserve.Exception;
public class UserExistsException extends RuntimeException {
    public UserExistsException(String message) {
        super(message);
    }
}

