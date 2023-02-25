package com.personal.virtualPets.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

	//TODO create new profile
	public ResponseEntity<?> createProfile(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}

	//TODO Look up profiles
	public ResponseEntity<?> getById(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	public ResponseEntity<?> getByNickname(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	public ResponseEntity<?> getOwnerOfPet(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	public ResponseEntity<?> getByEmail(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	public ResponseEntity<?> getByUsername(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	
	//TODO get all profiles
	public ResponseEntity<?> getAllProfiles(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	
	//TODO change profile
	public ResponseEntity<?> changeProfile(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	
	//TODO delete profile
	public ResponseEntity<?> deleteProfile(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
}
