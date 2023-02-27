package com.personal.virtualPets.dtos;

import java.util.List;

public class ProfileResponseDTO {
	
	private Integer id;
	private String username;
	private String nickname;
	private List<PetsResponseDTO> pets;
	
	public ProfileResponseDTO() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public List<PetsResponseDTO> getPets() {
		return pets;
	}

	public void setPets(List<PetsResponseDTO> pets) {
		this.pets = pets;
	}

	public ProfileResponseDTO(Integer id, String username, String nickname, List<PetsResponseDTO> pets) {
		super();
		this.id = id;
		this.username = username;
		this.nickname = nickname;
		this.pets = pets;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
