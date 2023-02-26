package com.personal.virtualPets.services;

import org.springframework.stereotype.Service;

import com.personal.virtualPets.dtos.UserResponseDTO;
import com.personal.virtualPets.entities.UserEntity;

@Service
public class DTOServicesImp implements DTOServices{

	//Making DTOs from database in
	@Override
	public UserResponseDTO userToDto(UserEntity user) {
		UserResponseDTO dto = new UserResponseDTO();
		dto.setEmail(user.getEmail());
		dto.setRole(user.getRole());
		dto.setUsername(user.getUsername());
		return dto;
	}

}
