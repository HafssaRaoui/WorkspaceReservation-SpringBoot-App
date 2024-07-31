package com.hafssa.reservationposition.security;


import com.hafssa.reservationposition.entities.User;
import com.hafssa.reservationposition.repositories.UserRepository;
import com.nimbusds.jwt.JWTClaimsSet;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtEncoder jwtEncoder;



    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }


    @PostMapping("/login")
    public Map<String,String> login(String email, String password){
    org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));

        // Récupérer les informations utilisateur
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }


    //génération du token avec paramètres

        Instant instant = Instant.now();
        String scope = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(" "));
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .issuedAt(instant)
                .expiresAt(instant.plus(120, ChronoUnit.MINUTES))
                .subject(email)
                .claim("scope",scope)
                .claim("userId", user.getId())
                .claim("firstName", user.getFirstName())
                .claim("lastName", user.getLastName())
                .build();


        JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(
                JwsHeader.with(MacAlgorithm.HS512).build(),jwtClaimsSet
        );

        // ici on génère le token , puis on le récupère sous forme d'un string
        String jwt = jwtEncoder.encode(jwtEncoderParameters).getTokenValue();

        return Map.of("access-token",jwt);
    }
}
