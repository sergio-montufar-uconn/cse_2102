package com.example.demo;

import com.example.demo.service.EmailValidator;
import com.example.demo.service.PasswordValidator;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    private final EmailValidator service = new EmailValidator();

    @Test
    void testValidEmail() {
        assertTrue(service.validEmail("example@example.com"));
    }

    @Test
    void testInvalidEmail() {
        assertFalse(service.validEmail("invalid-email"));
    }
}

class PasswordValidatorTest {

    private final PasswordValidator service = new PasswordValidator();

    @Test
    void testStrongPassword() {
        assertTrue(service.isStrongPassword("StrongPass123"));
    }

    @Test
    void testWeakPassword() {
        assertFalse(service.isStrongPassword("weak"));
    }
}