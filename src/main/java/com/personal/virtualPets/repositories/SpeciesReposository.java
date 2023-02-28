package com.personal.virtualPets.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.personal.virtualPets.entities.SpeciesEntity;

public interface SpeciesReposository extends CrudRepository<SpeciesEntity, Integer> {

	boolean existsByName(String name);

	Optional<SpeciesEntity> findByName(String name);

}
