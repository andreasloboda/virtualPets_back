package com.personal.virtualPets.repositories;

import org.springframework.data.repository.CrudRepository;

import com.personal.virtualPets.entities.PetEntity;

public interface PetRepository extends CrudRepository<PetEntity, Integer>{

}
