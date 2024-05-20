package com.riwi.frol.infrastructure.services;


@Service
public class TokeService {
    @Value("${security.jwt.token.secret-key}")
    private String jwtSecret;

    public boolean isValidToken(String token) {
        String receivedJwtSecret = getJwtSecretFromToken(token);
        return jwtSecret.equals(receivedJwtSecret);
    }

    private String getJwtSecretFromToken(String token) {
        
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.get("jwt_secret", String.class);
    }
}