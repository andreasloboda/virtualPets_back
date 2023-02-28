package com.personal.virtualPets.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.personal.virtualPets.dtos.PetsRequestDto;
import com.personal.virtualPets.dtos.PetsResponseDTO;
import com.personal.virtualPets.entities.PetEntity;
import com.personal.virtualPets.repositories.PetRepository;
import com.personal.virtualPets.repositories.ProfileRepository;
import com.personal.virtualPets.repositories.SpeciesReposository;

@Service
public class PetServicesImp implements PetServices {

	@Autowired
	private PetRepository petRepo;
	@Autowired
	private DTOServices dtoServ;
	@Autowired
	private ProfileRepository profRepo;
	@Autowired
	private SpeciesReposository spRepo;

	@Override
	public ResponseEntity<?> newPet(PetsRequestDto data) {
		if (petRepo.existsByName(data.getName()))
			return new ResponseEntity<> ("Name already taken", HttpStatus.BAD_REQUEST);
		if (!profRepo.existsById(data.getOwnerId()))
			return new ResponseEntity<> ("Profile does not exist", HttpStatus.BAD_REQUEST);
		if (!spRepo.existsById(data.getSpeciesId()))
			return new ResponseEntity<> ("Species does not exist", HttpStatus.BAD_REQUEST);
		PetEntity pet = new PetEntity();
		pet.setName(data.getName());
		pet.setOwner(profRepo.findById(data.getOwnerId()).orElse(null));
		pet.setSpecies(spRepo.findById(data.getSpeciesId()).orElse(null));
		PetsResponseDTO resp = dtoServ.petToDto(petRepo.save(pet));
		return new ResponseEntity<> (resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAll() {
		List<PetEntity> pets = (List<PetEntity>) petRepo.findAll();
		List<PetsResponseDTO> resp = new ArrayList<>();
		for (PetEntity i : pets)
			resp.add(dtoServ.petToDto(i));
		return new ResponseEntity<> (resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getPetById(Integer id) {
		PetEntity pet = petRepo.findById(id).orElse(null);
		if (pet.equals(null))
			return new ResponseEntity<>("Pet does not exist", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<> (dtoServ.petToDto(pet), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getPetByName(String name) {
		PetEntity pet = petRepo.findByName(name).orElse(null);
		if (pet.equals(null))
			return new ResponseEntity<>("Pet does not exist", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<> (dtoServ.petToDto(pet), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getPetsBySpecie(Integer id) {
		List<PetEntity> pets = (List<PetEntity>) petRepo.findAllBySpeciesId(id);
		List<PetsResponseDTO> resp = new ArrayList<>();
		for (PetEntity i : pets)
			resp.add(dtoServ.petToDto(i));
		return new ResponseEntity<> (resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getPetsByOwner(Integer id) {
		List<PetEntity> pets = (List<PetEntity>) petRepo.findAllByOwnerId(id);
		List<PetsResponseDTO> resp = new ArrayList<>();
		for (PetEntity i : pets)
			resp.add(dtoServ.petToDto(i));
		return new ResponseEntity<> (resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deletePet(Integer id) {
		PetEntity pet = petRepo.findById(id).orElse(null);
		if (pet.equals(null))
			return new ResponseEntity<>("Pet does not exist", HttpStatus.BAD_REQUEST);
		petRepo.deleteById(id);
		return new ResponseEntity<> ("Pet deleted", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> editPet(Integer id, PetsRequestDto data) {
		PetEntity pet = petRepo.findById(id).orElse(null);
		if (pet.equals(null))
			return new ResponseEntity<>("Pet does not exist", HttpStatus.BAD_REQUEST);
		if (!data.getName().equals(null) && !data.getName().equals(pet.getName())) {
			if (petRepo.existsByName(pet.getName()))
				return new ResponseEntity<>("Name not available", HttpStatus.BAD_REQUEST);
			else
				pet.setName(data.getName());
		}
		if (!data.getOwnerId().equals(null)) {
			if (profRepo.existsById(data.getOwnerId()))
				pet.setOwner(profRepo.findById(data.getOwnerId()).orElse(null));
			else
				return new ResponseEntity<>("Profile does not exist", HttpStatus.BAD_REQUEST);
		}
		if (!data.getSpeciesId().equals(null)) {
			if (spRepo.existsById(data.getSpeciesId()))
				pet.setSpecies(spRepo.findById(data.getSpeciesId()).orElse(null));
			else
				return new ResponseEntity<>("Species does not exist", HttpStatus.BAD_REQUEST);
		}
		PetsResponseDTO resp = dtoServ.petToDto(petRepo.save(pet));
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> removeOwner(Integer id) {
		PetEntity pet = petRepo.findById(id).orElse(null);
		if (pet.equals(null))
			return new ResponseEntity<>("Pet does not exist", HttpStatus.BAD_REQUEST);
		pet.setOwner(null);
		PetsResponseDTO resp = dtoServ.petToDto(petRepo.save(pet));
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

}
