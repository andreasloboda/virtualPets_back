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

import com.personal.virtualPets.dtos.PetsRequestDto;
import com.personal.virtualPets.services.PetServices;

@RestController
@RequestMapping("/api/v1/pet")
public class PetsController {

	@Autowired
	private PetServices petServ;
	
	@PostMapping("/")
	public ResponseEntity<?> createPet(@RequestBody PetsRequestDto data){
		return petServ.newPet(data);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllPets(){
		return petServ.getAll();
	}
	@GetMapping("/id/{id}")
	public ResponseEntity<?> getPetById(@PathVariable Integer id){
		return petServ.getPetById(id);
	}
	@GetMapping("/name/{name}")
	public ResponseEntity<?> getPetByName(@PathVariable String name){
		return petServ.getPetByName(name);
	}
	@GetMapping("/species/{id}")
	public ResponseEntity<?> getPetsOfSpecie(@PathVariable Integer id){
		return petServ.getPetsBySpecie(id);
	}
	@GetMapping("/owner/{id}")
	public ResponseEntity<?> getPetsOfOwner(@PathVariable Integer id){
		return petServ.getPetsByOwner(id);
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> deletePet(@PathVariable Integer id){
		return petServ.deletePet(id);
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<?> changePet(@PathVariable Integer id, @RequestBody PetsRequestDto data){
		return petServ.editPet(id, data);
	}
	@PutMapping("/disown/{id}")
	public ResponseEntity<?> disownPet(@PathVariable Integer id){
		return petServ.removeOwner(id);
	}
}
