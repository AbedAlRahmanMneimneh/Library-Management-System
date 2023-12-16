package com.library_database_controller;

public class IncorrectFileTypeException extends Exception {
    public IncorrectFileTypeException(String errorMessage) {
        super(errorMessage);
    }

}
