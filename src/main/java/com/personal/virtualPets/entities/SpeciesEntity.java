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

	//TODO expand so species can have alternate colors;
	//then individual pets will be related to their color-species combination
	//rather than just species. All pets created before that point will be
	//appointed either random color or specific color for non-converted pets.
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "SpecieId")
	private Integer id;
	@Version
	private Integer version;
	@Column(nullable = false, unique = true)
	private String name;
	
	@OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "species")
	private List<PetEntity> pets;

	public SpeciesEntity() {
		super();
	}

	public SpeciesEntity(Integer id, Integer version, String name, List<PetEntity> pets) {
		super();
		this.id = id;
		this.version = version;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PetEntity> getPets() {
		return pets;
	}

	public void setPets(List<PetEntity> pets) {
		this.pets = pets;
	}
}
