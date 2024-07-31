package com.hafssa.reservationposition.services;

import com.hafssa.reservationposition.entities.User;
import com.hafssa.reservationposition.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.security.core.userdetails.User.withUsername;


@Service
public class CustomUserDetailsService implements UserDetailsService {

        @Autowired
        private UserRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            User user = userRepository.findByEmail(email);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }

            org.springframework.security.core.userdetails.User.UserBuilder builder = withUsername(user.getEmail());
            builder.password(user.getPassword());
            builder.authorities(user.getRole());

            return builder.build();
        }
    }


