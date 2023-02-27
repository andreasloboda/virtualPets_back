package com.personal.virtualPets.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.personal.virtualPets.dtos.ProfileRequestDTO;
import com.personal.virtualPets.dtos.ProfileResponseDTO;
import com.personal.virtualPets.entities.PetEntity;
import com.personal.virtualPets.entities.ProfileEntity;
import com.personal.virtualPets.entities.UserEntity;
import com.personal.virtualPets.repositories.PetRepository;
import com.personal.virtualPets.repositories.ProfileRepository;
import com.personal.virtualPets.repositories.UserRepository;

@Service
public class ProfileServicesImp implements ProfileServices {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ProfileRepository profileRepo;
	@Autowired
	private DTOServices dtoServ;
	@Autowired
	private PetRepository petRepo;

	@Override
	public ResponseEntity<?> newProfile(Integer id, ProfileRequestDTO data) {
		if (id == null || data.equals(null))
			return new ResponseEntity<>("Data incomplete", HttpStatus.BAD_REQUEST);
		if (!userRepo.existsById(id))
			return new ResponseEntity<>("User does not exist", HttpStatus.BAD_REQUEST);
		if (profileRepo.existsById(id))
			return new ResponseEntity<>("Profile already exists", HttpStatus.BAD_REQUEST);
		ProfileEntity prof = new ProfileEntity();
		prof.setId(id);
		prof.setUser(userRepo.findById(id).orElse(null));
		// Nickname CAN be blank. In that case, Nickname is set to Username
		if (data.getNickname().isBlank())
			prof.setNickname(prof.getUser().getUsername());
		else
			prof.setNickname(data.getNickname());
		prof.setPets(null);
		ProfileResponseDTO resp = dtoServ.profileToDto(prof);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getProfileById(Integer id) {
		ProfileEntity prof = profileRepo.findById(id).orElse(null);
		if (prof.equals(null))
			return new ResponseEntity<>("Profile does not exist", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(dtoServ.profileToDto(prof), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getProfileByNickname(String name) {
		List<ProfileEntity> profs = profileRepo.findAllByNickname(name);
		List<ProfileResponseDTO> resp = new ArrayList<>();
		for (ProfileEntity i : profs)
			resp.add(dtoServ.profileToDto(i));
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getProfileByPet(Integer id) {
		PetEntity pet = petRepo.findById(id).orElse(null);
		if (pet.equals(null))
			return new ResponseEntity<>("Pet does not exist", HttpStatus.BAD_REQUEST);
		ProfileEntity prof = pet.getOwner();
		if (prof.equals(null))
			return new ResponseEntity<>("Pet is abandoned!", HttpStatus.OK);
		return new ResponseEntity<>(dtoServ.profileToDto(prof), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getProfileByUsername(String name) {
		if (!userRepo.existsByUsername(name))
			return new ResponseEntity<>("Username does not exist", HttpStatus.BAD_REQUEST);
		UserEntity user = userRepo.findByUsername(name);
		ProfileEntity prof = user.getProfile();
		if (prof.equals(null))
			return new ResponseEntity<>("No profile associated with this username", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(dtoServ.profileToDto(prof), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAllProfiles() {
		List<ProfileEntity> profs = (List<ProfileEntity>) profileRepo.findAll();
		List<ProfileResponseDTO> resp = new ArrayList<>();
		for (ProfileEntity i : profs)
			resp.add(dtoServ.profileToDto(i));
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> editProfile(Integer id, ProfileRequestDTO data) {
		ProfileEntity prof = profileRepo.findById(id).orElse(null);
		if (prof.equals(null))
			return new ResponseEntity<>("Profile not found", HttpStatus.BAD_REQUEST);
		if (!data.getNickname().isBlank())
			prof.setNickname(data.getNickname());
		ProfileResponseDTO resp = dtoServ.profileToDto(profileRepo.save(prof));
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	// TODO abandon pets
	@Override
	public ResponseEntity<?> deleteProfile(Integer id) {
		if (!profileRepo.existsById(id))
			return new ResponseEntity<>("Profile not found", HttpStatus.BAD_REQUEST);
		profileRepo.deleteById(id);
		return new ResponseEntity<>("Profile deleted", HttpStatus.OK);
	}

}
