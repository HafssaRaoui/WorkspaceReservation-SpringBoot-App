package com.hafssa.reservationposition.repositories;

import com.hafssa.reservationposition.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
