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
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDto updateUserById(int id, UserDto userDto) {
        return null;
    }

    @Override
    public String deleteUserById(int id) {
        return "";
    }
}
