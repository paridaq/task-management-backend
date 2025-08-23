package com.code.task_user_service.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.util.*;

public class JwtProvider {

   private  static  SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());


    public static String generateToken(Authentication auth){
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

        String roles = populateAuthorities(authorities);
        String jwt = Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+86400000))
                .claim("email",auth.getName())
                .claim("authorities",roles)
                .signWith(key)
                .compact();



    }
    public static String populateAuthorities(Collection<? extends GrantedAuthority> collections){
        Set<String> auths = new HashSet<>();
        for(GrantedAuthority authority:collections){
            auths.add(authority.getAuthority());

        }
        return String.join(",",auths);

    }
}
