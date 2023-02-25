package com.personal.virtualPets.entities;

import com.personal.virtualPets.enums.UserRole;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Version;

@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private Integer id;
	@Version
	private Integer version;
	@Column(unique = true, nullable = false)
	private String username;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private UserRole role;
	@Column(nullable = false)
	private String password;
	private String verification;
	
	@OneToOne (mappedBy = "user", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private ProfileEntity profile;

	public UserEntity() {
		super();
	}

	public UserEntity(Integer id, Integer version, String username, String email, UserRole role, String password,
			String verification, ProfileEntity profile) {
		super();
		this.id = id;
		this.version = version;
		this.username = username;
		this.email = email;
		this.role = role;
		this.password = password;
		this.verification = verification;
		this.profile = profile;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

	public ProfileEntity getProfile() {
		return profile;
	}

	public void setProfile(ProfileEntity profile) {
		this.profile = profile;
	}
}
