package com.dnzocoud.mantix_api.domain.services;

public interface IPasswordHashing {
    public String hashPassword(String password, String salt) throws Exception;

    public boolean veirfyPassword(String password, String storedSalt, String storedHash);

    public String generateSalt();
}
