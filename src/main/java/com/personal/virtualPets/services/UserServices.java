package com.personal.virtualPets.services;

import org.springframework.http.ResponseEntity;

import com.personal.virtualPets.dtos.PasswordDTO;
import com.personal.virtualPets.dtos.UserRequestDTO;
import com.personal.virtualPets.enums.UserRole;

public interface UserServices {

	ResponseEntity<?> newUser(UserRequestDTO data, UserRole role);

	ResponseEntity<?> getUserById(Integer id);

	ResponseEntity<?> getUserByUsername(String username);

	ResponseEntity<?> getAllAdmins();

	ResponseEntity<?> getAllUsers();

	ResponseEntity<?> deleteUser(Integer id);

	ResponseEntity<?> editUser(Integer id, UserRequestDTO data);

	ResponseEntity<?> verify(Integer id, String ver);

	ResponseEntity<?> changePass(Integer id, PasswordDTO pass);

}
