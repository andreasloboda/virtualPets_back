package com.personal.virtualPets.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.personal.virtualPets.entities.ProfileEntity;

public interface ProfileRepository extends CrudRepository<ProfileEntity, Integer>{

	List<ProfileEntity> findAllByNickname(String name);

}
