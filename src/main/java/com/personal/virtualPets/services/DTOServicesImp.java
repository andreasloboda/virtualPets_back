package com.personal.virtualPets.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.personal.virtualPets.dtos.PetsResponseDTO;
import com.personal.virtualPets.dtos.ProfileResponseDTO;
import com.personal.virtualPets.dtos.SpeciesResponseDTO;
import com.personal.virtualPets.dtos.UserResponseDTO;
import com.personal.virtualPets.entities.PetEntity;
import com.personal.virtualPets.entities.ProfileEntity;
import com.personal.virtualPets.entities.SpeciesEntity;
import com.personal.virtualPets.entities.UserEntity;

@Service
public class DTOServicesImp implements DTOServices{

	//Making DTOs from database info
	@Override
	public UserResponseDTO userToDto(UserEntity user) {
		UserResponseDTO dto = new UserResponseDTO();
		dto.setId(user.getId());
		dto.setEmail(user.getEmail());
		dto.setRole(user.getRole());
		dto.setUsername(user.getUsername());
		return dto;
	}

	@Override
	public ProfileResponseDTO profileToDto(ProfileEntity prof) {
		ProfileResponseDTO dto = new ProfileResponseDTO();
		dto.setId(prof.getId());
		dto.setUsername(prof.getUser().getUsername());
		dto.setNickname(prof.getNickname());
		List<PetsResponseDTO> pets = new ArrayList<>();
		if (!prof.getPets().equals(null)) {
			for (PetEntity i : prof.getPets())
				pets.add(petToDto(i));
		}
		dto.setPets(pets);
		return dto;
	}

	//TODO EXPAND when detailing pets
	@Override
	public PetsResponseDTO petToDto(PetEntity i) {
		return null;
	}

	@Override
	public SpeciesResponseDTO SpeciesToDto(SpeciesEntity species) {
		SpeciesResponseDTO dto = new SpeciesResponseDTO();
		dto.setId(species.getId());
		dto.setName(species.getName());
		return dto;
	}

}
