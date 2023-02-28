package com.personal.virtualPets.dtos;

public class PetsResponseDTO {

	private Integer petId;
	private String petName;
	private Integer ownerId;
	private String ownerName;
	private Integer speciesId;
	private String speciesName;
	
	
	public PetsResponseDTO() {
		super();
	}
	public PetsResponseDTO(Integer petId, String petName, Integer ownerId, String ownerName, Integer speciesId,
			String speciesName) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.speciesId = speciesId;
		this.speciesName = speciesName;
	}
	public Integer getPetId() {
		return petId;
	}
	public void setPetId(Integer petId) {
		this.petId = petId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public Integer getSpeciesId() {
		return speciesId;
	}
	public void setSpeciesId(Integer speciesId) {
		this.speciesId = speciesId;
	}
	public String getSpeciesName() {
		return speciesName;
	}
	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}
}
