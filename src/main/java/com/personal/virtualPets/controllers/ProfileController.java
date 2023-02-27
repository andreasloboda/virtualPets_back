package com.personal.virtualPets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.virtualPets.dtos.ProfileRequestDTO;
import com.personal.virtualPets.services.ProfileServices;

@RestController
@RequestMapping("/api/v1")
public class ProfileController {

	@Autowired
	private ProfileServices profServ;
	
	@PostMapping("/user/{id}/profile")
	public ResponseEntity<?> createProfile(@RequestBody ProfileRequestDTO data, @PathVariable Integer id){
		return profServ.newProfile(id, data);
	}

	@GetMapping("/profile/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		return profServ.getProfileById(id);
	}
	@GetMapping("/profile/nick/{name}")
	public ResponseEntity<?> getByNickname(@PathVariable String name){
		return profServ.getProfileByNickname(name);
	}
	@GetMapping("/profile/pet/{id}")
	public ResponseEntity<?> getOwnerOfPet(@PathVariable Integer id){
		return profServ.getProfileByPet(id);
	}
	@GetMapping("/profile/user/{name}")
	public ResponseEntity<?> getByUsername(@PathVariable String name){
		return profServ.getProfileByUsername(name);
	}
	@GetMapping("/profile/all")
	public ResponseEntity<?> getAllProfiles(){
		return profServ.getAllProfiles();
	}
	
	@PutMapping("/profile/id/{id}")
	public ResponseEntity<?> changeProfile(@PathVariable Integer id, @RequestBody ProfileRequestDTO data){
		return profServ.editProfile(id, data);
	}
	
	@DeleteMapping("/profile/id/{id}")
	public ResponseEntity<?> deleteProfile(@PathVariable Integer id){
		return profServ.deleteProfile(id);
	}
}
