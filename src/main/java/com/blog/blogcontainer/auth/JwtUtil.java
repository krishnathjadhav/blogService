package com.blog.blogcontainer.auth;


import com.blog.model.User;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {


    private final String secret_key = "mysecretkey";
    private long accessTokenValidity = 60*60*1000;

    private final JwtParser jwtParser;

    private final String TOKEN_HEADER = "Authorization";
    private final String TOKEN_PREFIX = "Bearer ";

    public JwtUtil(){
        this.jwtParser = Jwts.parser().setSigningKey(secret_key);
    }

    public String createToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getName());
        claims.put("name",user.getName());

        Date tokenCreateTime = new Date();
        Date tokenValidity = new Date(tokenCreateTime.getTime() + TimeUnit.MINUTES.toMillis(accessTokenValidity));
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenValidity))
                .signWith(SignatureAlgorithm.HS256, secret_key)
                .compact();
    }




    public Claims resolveClaims(HttpServletRequest req) {
        try {
            String token = resolveToken(req);
            if (token != null) {
                return jwtParser.parseClaimsJws(token).getBody();
            }
            return null;
        } catch (ExpiredJwtException ex) {
            req.setAttribute("expired", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            req.setAttribute("invalid", ex.getMessage());
            throw ex;
        }
    }

    public String resolveToken(HttpServletRequest request) {

        String bearerToken = request.getHeader(TOKEN_HEADER);
        System.out.println("bearer toekn in request: "+bearerToken);
        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
            String actualToken = bearerToken.substring(TOKEN_PREFIX.length());
            System.out.println("actualToken: "+actualToken);
            return actualToken;
        }
        return null;
    }

    public boolean validateClaims(Claims claims) throws AuthenticationException {
        try {
            Date exp = claims.getExpiration();
            Date current = new Date();
            System.out.println("exp date"+exp.toString()+", current Date: "+current.toString()+", Result: "+claims.getExpiration().after(new Date()));
            boolean isTokenValid = claims.getExpiration().after(new Date());
            System.out.println("isTokenValid: "+isTokenValid);
            return isTokenValid;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getEmail(Claims claims) {
        return claims.getSubject();
    }

    private List<String> getRoles(Claims claims) {
        return (List<String>) claims.get("roles");
    }


}
