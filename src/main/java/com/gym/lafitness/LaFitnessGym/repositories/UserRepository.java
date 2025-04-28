package com.gym.lafitness.LaFitnessGym.repositories;

import com.gym.lafitness.LaFitnessGym.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
