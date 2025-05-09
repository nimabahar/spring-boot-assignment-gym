package com.gym.lafitness.LaFitnessGym.services.impl;

import com.gym.lafitness.LaFitnessGym.dtos.GymDto;
import com.gym.lafitness.LaFitnessGym.entities.Gym;
import com.gym.lafitness.LaFitnessGym.mappers.GymMapper;
import com.gym.lafitness.LaFitnessGym.repositories.GymRepository;
import com.gym.lafitness.LaFitnessGym.services.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymServiceImpl implements GymService {

    @Autowired
    private GymRepository gymRepository;
    @Autowired
    private GymMapper gymMapper;

    @Override
    public GymDto createGym(GymDto gymDto) {

        Gym gym = gymMapper.mapToGym(gymDto);
        Gym savedGym = gymRepository.save(gym);
        return gymMapper.mapToGymDto(savedGym);
    }

    @Override
    public GymDto getGymById(int id) {

        Gym gym = gymRepository.findById(id).orElseThrow( () -> new RuntimeException("This ID does not exist.") );
        return gymMapper.mapToGymDto(gym);
    }

    @Override
    public List<GymDto> getAllGyms() {

        List<Gym> gyms = gymRepository.findAll();
        List<GymDto> gymDtos =  gyms.stream().map(gymMapper::mapToGymDto).toList();

        return gymDtos;
    }

    @Override
    public GymDto updateGymById(int id, GymDto gymDto) {

        Gym gym = gymRepository.findById(id).orElseThrow( () -> new RuntimeException("This ID does not exist.") );
        gym.setName(gymDto.getName());
        gym.setAddress(gymDto.getAddress());

        Gym savedGym = gymRepository.save(gym);


        return gymMapper.mapToGymDto(savedGym);
    }

    @Override
    public String deleteGymById(int id) {

        if(gymRepository.existsById(id)){

            gymRepository.deleteById(id);
            return "Successfully deleted Gym" + " " + id;
        }

        return "No Record of that ID found.";
    }
}
