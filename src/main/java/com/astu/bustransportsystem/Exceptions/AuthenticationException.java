package com.astu.bustransportsystem.Exceptions;

public class AuthenticationException extends Exception {
    public AuthenticationException() {
        super("Invalid SSN & Password Combination");
    }
    public AuthenticationException(String message) {
        super(message);
    }
}
