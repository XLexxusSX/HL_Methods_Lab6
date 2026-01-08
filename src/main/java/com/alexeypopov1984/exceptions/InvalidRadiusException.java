package com.alexeypopov1984.exceptions;

public class InvalidRadiusException extends Exception {

    public InvalidRadiusException() {
        super("Radius dolzhen byt' > 0");
    }

    public InvalidRadiusException(String message) {
        super(message);
    }
}

