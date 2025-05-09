package com.gym.lafitness.LaFitnessGym.controllers;

import com.gym.lafitness.LaFitnessGym.dtos.GymDto;
import com.gym.lafitness.LaFitnessGym.services.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gyms")
public class GymController {

    @Autowired
    private GymService gymService;

    @PostMapping
    public ResponseEntity<GymDto> addGym(@RequestBody GymDto gymDto){

        return new ResponseEntity<>(gymService.createGym(gymDto), HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<GymDto> getGym(@PathVariable int id){

        return ResponseEntity.ok(gymService.getGymById(id));
    }

    @GetMapping
    public ResponseEntity<List<GymDto>> getAllGyms(){

        List<GymDto> gymDtos =  gymService.getAllGyms();
        return ResponseEntity.ok(gymDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GymDto> updateGymById(@PathVariable int id, @RequestBody GymDto gymDto){

        GymDto updatedGymDto = gymService.updateGymById(id, gymDto);
        return ResponseEntity.ok(updatedGymDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGymById(@PathVariable int id){

        String response = gymService.deleteGymById(id);
        return ResponseEntity.ok(response);
    }


}
