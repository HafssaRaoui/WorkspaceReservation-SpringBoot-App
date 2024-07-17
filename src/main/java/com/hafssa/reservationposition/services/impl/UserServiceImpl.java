package com.hafssa.reservationposition.services.impl;

import com.hafssa.reservationposition.dtos.UserDto;
import com.hafssa.reservationposition.entities.User;
import com.hafssa.reservationposition.repositories.UserRepository;
import com.hafssa.reservationposition.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }

    @Override
    public UserDto getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return convertToDto(user);

    }

    private UserDto convertToDto(User user) {
        return new UserDto(user.getId(), user.getMatricule(), user.getFirstName(), user.getLastName(), user.getRole(), user.getEmail());
    }
}
