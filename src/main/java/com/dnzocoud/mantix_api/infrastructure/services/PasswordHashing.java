package com.dnzocoud.mantix_api.infrastructure.services;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.stereotype.Service;

import com.dnzocoud.mantix_api.domain.services.IPasswordHashing;

@Service
public final class PasswordHashing implements IPasswordHashing {

    @Override
    public String hashPassword(String password, String salt) throws Exception {
        int iterations = 10000;
        int keyLength = 256;

        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), iterations, keyLength);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

        byte[] hash = factory.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(hash);
    }

    @Override
    public boolean veirfyPassword(String password, String storedSalt, String storedHash) {
        try {
            String hashToVerify = hashPassword(password, storedSalt);
            return hashToVerify.equals(storedHash);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String generateSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

}
