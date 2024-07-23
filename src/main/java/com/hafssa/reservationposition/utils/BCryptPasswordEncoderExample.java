package com.hafssa.reservationposition.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderExample {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Encoder les mots de passe des utilisateurs
        String password1 = "password"; // Remplacez par le mot de passe actuel
        String password2 = "password"; // Remplacez par le mot de passe actuel
        String password3 = "password"; // Remplacez par le mot de passe actuel
        String password4 = "password"; // Remplacez par le mot de passe actuel
        String password5 = "password"; // Remplacez par le mot de passe actuel

        String encodedPassword1 = encoder.encode(password1);
        String encodedPassword2 = encoder.encode(password2);
        String encodedPassword3 = encoder.encode(password3);
        String encodedPassword4 = encoder.encode(password4);
        String encodedPassword5 = encoder.encode(password5);

        System.out.println("Encoded password for anassenhaji@gmail.com: " + encodedPassword1);
        System.out.println("Encoded password for hafssaraoui@gmail.com: " + encodedPassword2);
        System.out.println("Encoded password for yasminesalhi@gmail.com: " + encodedPassword3);
        System.out.println("Encoded password for mariamlakhssassi@gmail.com: " + encodedPassword4);
        System.out.println("Encoded password for mohamedahmadi@gmail.com: " + encodedPassword5);
    }
}

