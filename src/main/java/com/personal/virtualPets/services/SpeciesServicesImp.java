package com.personal.virtualPets.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.personal.virtualPets.dtos.SpeciesRequestDTO;
import com.personal.virtualPets.dtos.SpeciesResponseDTO;
import com.personal.virtualPets.entities.SpeciesEntity;
import com.personal.virtualPets.repositories.SpeciesReposository;

@Service
public class SpeciesServicesImp implements SpeciesServices {

	@Autowired
	private SpeciesReposository spRepo;
	@Autowired
	private DTOServices dtoServ;
	
	@Override
	public ResponseEntity<?> newSpecies(SpeciesRequestDTO data) {
		if (spRepo.existsByName(data.getName()))
			return new ResponseEntity<> ("Please provide a different name.", HttpStatus.BAD_REQUEST);
		SpeciesEntity species = new SpeciesEntity();
		species.setName(data.getName());
		SpeciesResponseDTO resp = dtoServ.SpeciesToDto(spRepo.save(species));
		return new ResponseEntity<> (resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> editSpecies(Integer id, SpeciesRequestDTO data) {
		SpeciesEntity species = spRepo.findById(id).orElse(null);
		if (species.equals(null))
			return new ResponseEntity<> ("Species does not exist", HttpStatus.BAD_REQUEST);
		if (! data.getName().isBlank()) {
			if (! data.getName().equals(species.getName()))
				if (spRepo.existsByName(data.getName()))
					return new ResponseEntity<> ("Name not available", HttpStatus.BAD_REQUEST);
				else species.setName(data.getName());
		}
		SpeciesResponseDTO resp = dtoServ.SpeciesToDto(spRepo.save(species));
		return new ResponseEntity<> (resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getSpeciesById(Integer id) {
		SpeciesEntity species = spRepo.findById(id).orElse(null);
		if (species.equals(null))
			return new ResponseEntity<> ("Species does not exist", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<> (dtoServ.SpeciesToDto(species), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getSpeciesByName(String name) {
		SpeciesEntity species = spRepo.findByName(name).orElse(null);
		if (species.equals(null))
			return new ResponseEntity<> ("Species does not exist", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<> (dtoServ.SpeciesToDto(species), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> getAllSpecies() {
		List<SpeciesEntity> species = (List<SpeciesEntity>) spRepo.findAll();
		List<SpeciesResponseDTO> resp = new ArrayList<>();
		for (SpeciesEntity i : species)
			resp.add(dtoServ.SpeciesToDto(i));
		return new ResponseEntity<> (resp, HttpStatus.OK);
	}

	//TODO deleting species changes pets to a new species
	@Override
	public ResponseEntity<?> deleteSpecies(Integer id) {
		if (! spRepo.existsById(id))
			return new ResponseEntity<> ("Species does not exist", HttpStatus.BAD_REQUEST);
		spRepo.deleteById(id);
		return new ResponseEntity<> ("Species deleted", HttpStatus.OK);
	}

}
