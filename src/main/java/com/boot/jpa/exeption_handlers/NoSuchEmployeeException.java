package com.boot.jpa.exeption_handlers;

public class NoSuchEmployeeException  extends RuntimeException{
    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
