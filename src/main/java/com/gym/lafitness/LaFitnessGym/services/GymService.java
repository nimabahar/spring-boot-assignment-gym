package com.gym.lafitness.LaFitnessGym.services;

import com.gym.lafitness.LaFitnessGym.dtos.GymDto;

import java.util.List;

public interface GymService {

    GymDto createGym(GymDto gymDto);
    GymDto getGymById(int id);
    List<GymDto> getAllGyms();
    GymDto updateGymById(int id, GymDto gymDto);
    String deleteGymById(int id);
}
