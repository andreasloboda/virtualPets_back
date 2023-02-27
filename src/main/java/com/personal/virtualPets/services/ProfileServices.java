package com.personal.virtualPets.services;

import org.springframework.http.ResponseEntity;

import com.personal.virtualPets.dtos.ProfileRequestDTO;

public interface ProfileServices {

	ResponseEntity<?> newProfile(Integer id, ProfileRequestDTO data);

	ResponseEntity<?> getProfileById(Integer id);

	ResponseEntity<?> getProfileByNickname(String name);

	ResponseEntity<?> getProfileByPet(Integer id);

	ResponseEntity<?> getProfileByUsername(String name);

	ResponseEntity<?> getAllProfiles();

	ResponseEntity<?> editProfile(Integer id, ProfileRequestDTO data);

	ResponseEntity<?> deleteProfile(Integer id);

}
