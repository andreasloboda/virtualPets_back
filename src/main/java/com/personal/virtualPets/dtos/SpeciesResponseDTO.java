package com.personal.virtualPets.dtos;

public class SpeciesResponseDTO {

	private Integer id;
	private String name;
	
	public SpeciesResponseDTO() {
		super();
	}
	public SpeciesResponseDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
