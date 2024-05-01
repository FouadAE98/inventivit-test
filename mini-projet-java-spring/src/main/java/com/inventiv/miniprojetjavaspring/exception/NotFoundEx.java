package com.inventiv.miniprojetjavaspring.exception;


public class NotFoundEx extends RuntimeException {
    public NotFoundEx(String message) {
        super(message);
    }
}