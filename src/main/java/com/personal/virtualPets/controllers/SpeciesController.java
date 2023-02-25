package com.personal.virtualPets.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeciesController {

	//TODO Create new Species
	public ResponseEntity<?> createSpecies(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	//TODO Change species
	public ResponseEntity<?> changeSpecies(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	//TODO Look up species
	public ResponseEntity<?> getSpeciesById(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	public ResponseEntity<?> getSpeciesByName(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	public ResponseEntity<?> getAllSpecies(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	//TODO delete species
	public ResponseEntity<?> deleteSpecies(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
}
