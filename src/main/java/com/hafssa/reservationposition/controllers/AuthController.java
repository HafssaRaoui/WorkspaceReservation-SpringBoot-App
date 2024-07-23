package com.hafssa.reservationposition.controllers;

import com.hafssa.reservationposition.dtos.LoginRequest;
import com.hafssa.reservationposition.dtos.JwtResponse;
import com.hafssa.reservationposition.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        //System.out.println("bonjour");
        String token = authService.generateToken(loginRequest.getEmail(), loginRequest.getPassword());
      //  System.out.println("token:"+token);
        if (token != null) {
            //return ResponseEntity.ok("hello");
         return ResponseEntity.ok(new JwtResponse(token));

        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
    //
//    @GetMapping("/test")
//    public ResponseEntity<String> test() {
//        try {
//            return ResponseEntity.ok("Test réussi");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur: " + e.getMessage());
//        }
//    }
}


