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

import com.personal.virtualPets.dtos.SpeciesRequestDTO;
import com.personal.virtualPets.services.SpeciesServices;

@RestController
@RequestMapping("/api/v1")
public class SpeciesController {

	@Autowired
	private SpeciesServices spServ;
	
	@PostMapping("/species")
	public ResponseEntity<?> createSpecies(@RequestBody SpeciesRequestDTO data){
		return spServ.newSpecies(data);
	}
	
	@PutMapping("/species/id/{id}")
	public ResponseEntity<?> changeSpecies(@PathVariable Integer id, @RequestBody SpeciesRequestDTO data){
		return spServ.editSpecies(id, data);
	}
	
	@GetMapping("/species/id/{id}")
	public ResponseEntity<?> getSpeciesById(@PathVariable Integer id){
		return spServ.getSpeciesById(id);
	}
	@GetMapping("/species/name/{name}")
	public ResponseEntity<?> getSpeciesByName(@PathVariable String name){
		return spServ.getSpeciesByName(name);
	}
	@GetMapping("/species")
	public ResponseEntity<?> getAllSpecies(){
		return spServ.getAllSpecies();
	}
	
	@DeleteMapping("/species/id/{id}")
	public ResponseEntity<?> deleteSpecies(@PathVariable Integer id){
		return spServ.deleteSpecies(id);
	}
}
