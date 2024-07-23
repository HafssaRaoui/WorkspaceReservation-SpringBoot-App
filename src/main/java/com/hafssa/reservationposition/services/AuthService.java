package com.hafssa.reservationposition.services;

import com.hafssa.reservationposition.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.security.Key;
import java.util.Date;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String generateToken(String email, String password) {
        User user = userService.findByEmail(email);

//        System.out.println(passwordEncoder.encode(password));
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
           // System.out.println("password ok");
            return Jwts.builder()
                    .setSubject(email)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 864000000)) // 10 jours
                    .signWith(key)
                    .compact();
        }
        return null;
    }
}
//&& passwordEncoder.matches(password, user.getPassword())