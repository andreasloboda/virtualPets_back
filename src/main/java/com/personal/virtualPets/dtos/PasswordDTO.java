package com.personal.virtualPets.dtos;

public class PasswordDTO {

	private String oldPass;
	private String newPass;
	private String verPass;
	public PasswordDTO() {
		super();
	}
	public PasswordDTO(String oldPass, String newPass, String verPass) {
		super();
		this.oldPass = oldPass;
		this.newPass = newPass;
		this.verPass = verPass;
	}
	public String getOldPass() {
		return oldPass;
	}
	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}
	public String getNewPass() {
		return newPass;
	}
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	public String getVerPass() {
		return verPass;
	}
	public void setVerPass(String verPass) {
		this.verPass = verPass;
	}
}
