package com.gym.lafitness.LaFitnessGym.repositories;

import com.gym.lafitness.LaFitnessGym.entities.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym, Integer> {
}
