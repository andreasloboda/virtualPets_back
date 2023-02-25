package com.personal.virtualPets.entities;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Version;

@Entity
public class PetEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "petId")
	private Integer id;
	@Version
	private Integer version;
	@Column(nullable = false, unique = true)
	private String name;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "owner")
	private ProfileEntity owner;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "specie")
	private SpeciesEntity species;
	public PetEntity() {
		super();
	}
	public PetEntity(Integer id, Integer version, String name, ProfileEntity owner, SpeciesEntity species) {
		super();
		this.id = id;
		this.version = version;
		this.name = name;
		this.owner = owner;
		this.species = species;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProfileEntity getOwner() {
		return owner;
	}
	public void setOwner(ProfileEntity owner) {
		this.owner = owner;
	}
	public SpeciesEntity getSpecies() {
		return species;
	}
	public void setSpecies(SpeciesEntity species) {
		this.species = species;
	}
}
