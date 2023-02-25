package com.personal.virtualPets.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetsController {

	//TODO create pet
	public ResponseEntity<?> createPet(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	
	//TODO find pet
	public ResponseEntity<?> getAllPets(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	public ResponseEntity<?> getPetById(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	public ResponseEntity<?> getPetByName(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	public ResponseEntity<?> getPetsOfSpecie(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	public ResponseEntity<?> getPetsOfOwner(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	
	//TODO delete pet
	public ResponseEntity<?> deletePet(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	
	//TODO alter pet
	public ResponseEntity<?> changePet(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
}
