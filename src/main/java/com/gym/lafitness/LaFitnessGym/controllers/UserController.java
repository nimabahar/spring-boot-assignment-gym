package com.gym.lafitness.LaFitnessGym.controllers;

import com.gym.lafitness.LaFitnessGym.dtos.UserDto;
import com.gym.lafitness.LaFitnessGym.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){

        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);

    }


}
