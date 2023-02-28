package com.personal.virtualPets.dtos;

public class PetsRequestDto {

	private String name;
	private Integer ownerId;
	private Integer speciesId;
	
	
	public PetsRequestDto() {
		super();
	}
	public PetsRequestDto(String name, Integer ownerId, Integer speciesId) {
		super();
		this.name = name;
		this.ownerId = ownerId;
		this.speciesId = speciesId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public Integer getSpeciesId() {
		return speciesId;
	}
	public void setSpeciesId(Integer speciesId) {
		this.speciesId = speciesId;
	}
}
