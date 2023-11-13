package com.example.demo.service;

public class EmailValidator {
    private static final String REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public static boolean validEmail(String email) {
        return email.matches(REGEX);
    }
}