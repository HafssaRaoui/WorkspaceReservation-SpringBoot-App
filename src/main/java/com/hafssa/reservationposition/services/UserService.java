package com.hafssa.reservationposition.services;

import com.hafssa.reservationposition.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List <UserDto> getAllUsers();
    UserDto getUserById(int id);
}
