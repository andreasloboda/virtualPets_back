package com.personal.virtualPets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.personal.virtualPets.services.UserServices;

@RestController
public class UserController {

	@Autowired
	private UserServices userServ;
	
	//TODO Create new user
	public ResponseEntity<?> createUser(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	
	public ResponseEntity<?> createAdmin(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}

	
	//TODO Look up user
	public ResponseEntity<?> getUserById(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	public ResponseEntity<?> getUserByUsername(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	public ResponseEntity<?> getUserByEmail(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	public ResponseEntity<?> getAdmins(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}


	//TODO edit user
	public ResponseEntity<?> changeUser(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	public ResponseEntity<?> verifyUser(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
	public ResponseEntity<?> changePassword(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}

	//TODO delete user
	public ResponseEntity<?> deleteUser(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}

	//TODO get all users
	public ResponseEntity<?> getAllUsers(){
		return new ResponseEntity<> ("not implemented", HttpStatus.NOT_IMPLEMENTED);
	}
}
