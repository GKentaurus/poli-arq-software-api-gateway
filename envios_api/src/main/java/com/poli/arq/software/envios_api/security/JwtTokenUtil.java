package com.poli.arq.software.envios_api.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
@Log4j2
public class JwtTokenUtil {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @PostConstruct
    public void init() {
        this.printToken();
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public Claims validateToken(String token) {
        try {
            Key key = getSigningKey();

            log.info("Validating token with secret length: {}", jwtSecret.length());

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            log.info("Token validated successfully for subject: {}", claims.getSubject());
            log.info("Token expiration: {}", claims.getExpiration());

            return claims;

        } catch (ExpiredJwtException ex) {
            log.error("Token expired: {}", ex.getMessage());
            throw new RuntimeException("Token JWT expirado");
        } catch (MalformedJwtException ex) {
            log.error("Malformed token: {}", ex.getMessage());
            throw new RuntimeException("Token JWT mal formado");
        } catch (JwtException ex) {
            log.error("JWT validation failed: {}", ex.getMessage());
            throw new RuntimeException("Token JWT invalido: " + ex.getMessage());
        }
    }

    private void printToken() {
        try {
            Key key = getSigningKey();

            String testToken = Jwts.builder()
                    .setSubject("test_user")
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 24 horas
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();

            log.info("=== TOKEN PARA PRUEBAS ===");
            log.info("Bearer {}", testToken);
            log.info("=== FIN TOKEN ===");

        } catch (Exception e) {
            log.error("Error generating test token: {}", e.getMessage());
        }
    }
}
