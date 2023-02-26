package com.personal.virtualPets.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.personal.virtualPets.entities.UserEntity;
import com.personal.virtualPets.enums.UserRole;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

	boolean existsByUsername(String username);

	UserEntity findByUsername(String username);
	
	List<UserEntity> findAllByRole(UserRole role);

	boolean existsByEmail(String email);

	UserEntity findByEmail(String email);

}
