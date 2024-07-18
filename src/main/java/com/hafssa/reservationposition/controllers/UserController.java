package com.hafssa.reservationposition.controllers;


import com.hafssa.reservationposition.dtos.UserDto;
import com.hafssa.reservationposition.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
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






}
