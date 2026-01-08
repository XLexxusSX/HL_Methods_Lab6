package com.alexeypopov1984.exceptions;

public class InvalidWidthOrLengthException extends Exception {
    public InvalidWidthOrLengthException() {
        super("Dlina i Shirina pryamougol'nika dolzhny byt' > 0");
    }

    public InvalidWidthOrLengthException(String message) {
        super(message);
    }
}