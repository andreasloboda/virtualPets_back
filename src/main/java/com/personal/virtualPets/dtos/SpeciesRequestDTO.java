package com.personal.virtualPets.dtos;

public class SpeciesRequestDTO {

	private String name;

	public SpeciesRequestDTO() {
		super();
	}

	public SpeciesRequestDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
