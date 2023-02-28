package com.personal.virtualPets.services;

import org.springframework.http.ResponseEntity;

import com.personal.virtualPets.dtos.PetsRequestDto;

public interface PetServices {


	ResponseEntity<?> newPet(PetsRequestDto data);

	ResponseEntity<?> getAll();

	ResponseEntity<?> getPetById(Integer id);

	ResponseEntity<?> getPetByName(String name);

	ResponseEntity<?> getPetsBySpecie(Integer id);

	ResponseEntity<?> getPetsByOwner(Integer id);

	ResponseEntity<?> deletePet(Integer id);

	ResponseEntity<?> editPet(Integer id, PetsRequestDto data);

	ResponseEntity<?> removeOwner(Integer id);

}
