package com.personal.virtualPets.dtos;

public class ProfileRequestDTO {

	//This is a very empty place... But profile will eventually hold more stuff!
	
	private String nickname;

	public ProfileRequestDTO() {
		super();
	}

	public ProfileRequestDTO(String nickname) {
		super();
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
