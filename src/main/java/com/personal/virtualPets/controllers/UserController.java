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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personal.virtualPets.dtos.PasswordDTO;
import com.personal.virtualPets.dtos.UserRequestDTO;
import com.personal.virtualPets.enums.UserRole;
import com.personal.virtualPets.services.UserServices;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserServices userServ;
	
	@PostMapping("/user")
	public ResponseEntity<?> createUser(@RequestBody UserRequestDTO data){
		return userServ.newUser(data, UserRole.ROLE_VERIFY);
	}
	@PostMapping("/admin")
	public ResponseEntity<?> createAdmin(@RequestBody UserRequestDTO data){
		return userServ.newUser(data, UserRole.ROLE_ADMIN);
	}

	
	@GetMapping("/user/id/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id){
		return userServ.getUserById(id);
	}
	@GetMapping("/user/name/{username}")
	public ResponseEntity<?> getUserByUsername(@PathVariable String username){
		return userServ.getUserByUsername(username);
	}
	@GetMapping("/admin")
	public ResponseEntity<?> getAdmins(){
		return userServ.getAllAdmins();
	}
	@GetMapping("/user")
	public ResponseEntity<?> getAllUsers(){
		return userServ.getAllUsers();
	}

	//TODO edit user
	@PutMapping("/user/{id}")
	public ResponseEntity<?> changeUser(@PathVariable Integer id, @RequestBody UserRequestDTO data){
		return userServ.editUser(id, data);
	}
	@PutMapping("/user/{id}/verify")
	public ResponseEntity<?> verifyUser(@RequestParam String ver, @PathVariable Integer id){
		return userServ.verify(id, ver);
	}
	@PutMapping("/user/{id}/changepass")
	public ResponseEntity<?> changePassword(@PathVariable Integer id, @RequestBody PasswordDTO pass){
		return userServ.changePass(id, pass);
	}

	@DeleteMapping("/user/id/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id){
		return userServ.deleteUser(id);
	}

}
