package com.dnzocoud.mantix_api.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.dnzocoud.mantix_api.domain.models.User;

public class UserTest {
    @Test
    void shouldCreateUserWithValidData() {
        User user = new User(2L, "Doe", "sdasd", "sdasd", "sadasd", "sdasdasd", "", null, null, null);
        assertNotNull(user);
    }

    @Test
    void shouldThrowExceptionForInvalidEmail() {
        assertThrows(IllegalArgumentException.class,
                () -> new User(2L, "Doe", "sdasd", "sdasd", "sadasd", "sdasdasd", "", null, null, null));
    }
}
