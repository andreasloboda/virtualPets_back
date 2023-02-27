package com.personal.virtualPets.dtos;

import com.personal.virtualPets.enums.UserRole;

public class UserResponseDTO {

	private Integer id;
	private String username;
	private String email;
	private UserRole role;
	public UserResponseDTO() {
		super();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	public UserResponseDTO(Integer id, String username, String email, UserRole role) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
