package com.hafssa.reservationposition.controllers;


import com.hafssa.reservationposition.dtos.UserDto;
import com.hafssa.reservationposition.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hafssa.reservationposition.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController

@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:56578")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {

        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Integer id){

        return userService.getUserById(id);
    }

  /*  @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }*/




}
