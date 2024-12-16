package com.dnzocoud.mantix_api.infrastructure.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dnzocoud.mantix_api.application.dto.UserDTO;
import com.dnzocoud.mantix_api.application.mappers.UserMapper;
import com.dnzocoud.mantix_api.domain.models.User;
import com.dnzocoud.mantix_api.domain.services.ITokenService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtProvider implements ITokenService {
    private static final String SECRET_KEY = "42E4E2F8C1195F44FC7F224CEBA1EC93F6746A9A3D517543638AD4B58A";
    private static final long EXPIRATION_TIME = 86400000; // 1 día
    private SecretKey key;

    @Value("${jwt.secret}")
    private String secretKey;

    @PostConstruct
    public void init() {
        if (secretKey == null || secretKey.length() < 32) {
            throw new IllegalArgumentException("La clave secreta debe tener al menos 32 caracteres.");
        }
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String generateToken(final User user) {
        UserDTO userDto = UserMapper.toDto(user);
        return buildToken(userDto);
    }

    @Override
    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo para autenticarnos dentro del flujo de Spring
     * 
     * @return Claims
     */
    @Override
    @SuppressWarnings("unchecked")
    public Claims validateTokenAndReturnClaims(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
    }

    private String buildToken(final UserDTO user) {
        return Jwts.builder()
                .id(user.getId().toString())
                .claims(Map.of("name", user.getFullName()))
                .subject(user.getEmail()).issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSignKey())
                .compact();
    }

    private SecretKey getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}