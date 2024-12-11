package com.gategroup.mantix_api.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.gategroup.mantix_api.domain.models.User;
import com.gategroup.mantix_api.infrastructure.exceptions.InvalidCredentialsException;

public class UserTest {
    @Test
    void shouldCreateUserWithValidData() {
        User user = new User(2L, "Doe", "sdasd", "sdasd", "sadasd", "sdasdasd", null, null, null);
        assertNotNull(user);
    }

    @Test
    void shouldThrowExceptionForInvalidEmail() {
        assertThrows(InvalidCredentialsException.class,
                () -> new User(2L, "Doe", "sdasd", "sdasd", "sadasd", "sdasdasd", null, null, null));
    }
}
