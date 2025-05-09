package com.gym.lafitness.LaFitnessGym.services.impl;

import com.gym.lafitness.LaFitnessGym.dtos.UserDto;
import com.gym.lafitness.LaFitnessGym.entities.User;
import com.gym.lafitness.LaFitnessGym.mappers.UserMapper;
import com.gym.lafitness.LaFitnessGym.repositories.UserRepository;
import com.gym.lafitness.LaFitnessGym.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User ID not found."));
        return userMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::mapToUserDto).toList();
    }

    @Override
    public UserDto updateUserById(int id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User ID not found."));

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setProfilePicUrl(userDto.getProfilePicUrl());
        user.setUpdatedAt(userDto.getUpdatedAt());

        User updatedUser = userRepository.save(user);
        return userMapper.mapToUserDto(updatedUser);
    }

    @Override
    public String deleteUserById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User ID not found."));
        userRepository.delete(user);
        return "User deleted successfully.";
    }
}
