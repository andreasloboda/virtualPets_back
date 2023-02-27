package com.personal.virtualPets.services;


import com.personal.virtualPets.dtos.PetsResponseDTO;
import com.personal.virtualPets.dtos.ProfileResponseDTO;
import com.personal.virtualPets.dtos.UserResponseDTO;
import com.personal.virtualPets.entities.PetEntity;
import com.personal.virtualPets.entities.ProfileEntity;
import com.personal.virtualPets.entities.UserEntity;

public interface DTOServices {

	UserResponseDTO userToDto(UserEntity user);

	ProfileResponseDTO profileToDto(ProfileEntity prof);

	PetsResponseDTO petToDto(PetEntity pet);

}
