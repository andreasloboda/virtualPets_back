package com.personal.virtualPets.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.personal.virtualPets.entities.PetEntity;

public interface PetRepository extends CrudRepository<PetEntity, Integer>{

	boolean existsByName(String name);

	Optional<PetEntity> findByName(String name);

	List<PetEntity> findAllBySpeciesId(Integer id);

	List<PetEntity> findAllByOwnerId(Integer id);

}
