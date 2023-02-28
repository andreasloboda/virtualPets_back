package com.personal.virtualPets.services;

import org.springframework.http.ResponseEntity;

import com.personal.virtualPets.dtos.SpeciesRequestDTO;

public interface SpeciesServices {

	ResponseEntity<?> newSpecies(SpeciesRequestDTO data);

	ResponseEntity<?> editSpecies(Integer id, SpeciesRequestDTO data);

	ResponseEntity<?> getSpeciesById(Integer id);

	ResponseEntity<?> getSpeciesByName(String name);

	ResponseEntity<?> getAllSpecies();

	ResponseEntity<?> deleteSpecies(Integer id);

}
