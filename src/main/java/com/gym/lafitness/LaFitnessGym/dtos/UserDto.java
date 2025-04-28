package com.gym.lafitness.LaFitnessGym.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
