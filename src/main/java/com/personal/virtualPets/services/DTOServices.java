package com.personal.virtualPets.services;


import com.personal.virtualPets.dtos.UserResponseDTO;
import com.personal.virtualPets.entities.UserEntity;

public interface DTOServices {

	UserResponseDTO userToDto(UserEntity user);

}
