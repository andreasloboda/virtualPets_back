package com.personal.virtualPets.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

@Entity
public class SpeciesEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "SpecieId")
	private Integer id;
	@Version
	private Integer version;
	@Column(nullable = false, unique = true)
	private String species;
	
	@OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "species")
	private List<PetEntity> pets;

	public SpeciesEntity() {
		super();
	}

	public SpeciesEntity(Integer id, Integer version, String species, List<PetEntity> pets) {
		super();
		this.id = id;
		this.version = version;
		this.species = species;
		this.pets = pets;
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

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public List<PetEntity> getPets() {
		return pets;
	}

	public void setPets(List<PetEntity> pets) {
		this.pets = pets;
	}
}
