package com.personal.virtualPets.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Version;

@Entity
public class ProfileEntity {

	@Id
	@PrimaryKeyJoinColumn(name = "userId")
	private Integer id;
	@Version
	private Integer version;
	@Column(nullable = false)
	private String nickname;
	
	@OneToOne
	@MapsId
	@PrimaryKeyJoinColumn(name = "userId")
	private UserEntity user;
	
	@OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "owner")
	private List<PetEntity> pets;
	
	public ProfileEntity() {
		super();
	}
	public ProfileEntity(Integer id, Integer version, String nickname, UserEntity user, List<PetEntity> pets) {
		super();
		this.id = id;
		this.version = version;
		this.nickname = nickname;
		this.user = user;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public List<PetEntity> getPets() {
		return pets;
	}
	public void setPets(List<PetEntity> pets) {
		this.pets = pets;
	}

}
