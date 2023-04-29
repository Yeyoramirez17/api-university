package com.apiuniversity.security;

import com.apiuniversity.exception.BadRequestException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {
    // JWT signing key
    @Value("${api.jwt.signing-key}")
    private String SIGNING_KEY;

    // JWT expiration on milliseconds
    @Value("${app.jwt.expiration}")
    private Long JWT_EXPIRATION;

    // JWT refresh expiration on milliseconds
    @Value("${app.jwt.refresh-expiration}")
    private Long FRESH_JWT_EXPIRATION;

    public String generateToken(UserDetails userDetails) {
        return buildToken(new HashMap<>(), userDetails, JWT_EXPIRATION);
    }

    public String generateRefreshToken(UserDetails userDetails) {
        return buildToken(new HashMap<>(), userDetails, FRESH_JWT_EXPIRATION);
    }

    private String buildToken(Map<String, Object> extraClaims, UserDetails userDetails, Long expiration) {
        final String username = userDetails.getUsername();

        String token = Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration) )
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();

        return token;
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SIGNING_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsername(String token) {
        return this.getAllClaims(token).getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token);
            return true;
        }catch (SignatureException ex){
            throw new BadRequestException("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            throw new BadRequestException("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            throw new BadRequestException("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            throw new BadRequestException("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException("JWT claims string is empty.");
        }
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        final Date expiration = this.getAllClaims(token).getExpiration();
        return expiration.before(new Date());
    }
}
