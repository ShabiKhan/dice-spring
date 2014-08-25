package com.shabi.forms;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;


public class LoginRequestDTO {
	@NotNull
	private String email;
	 
	@NotNull
	private String password;
	
	public LoginRequestDTO(String email, String password) {
		this.email = email;
	    this.password = password;
	}

	public LoginRequestDTO() {
		email = " ";
	    password = " ";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
