package com.MM.TutorsHighApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Data
@Getter
@Setter
@Entity
public class Admin {

	private Long id;
	private String name;
	private String qualification;
	@Id

	private String email;
	private String password;
	public Admin(Long id, String name, String qualification, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.qualification = qualification;
		this.email = email;
		this.password = password;
	}
	public Admin() {
	
	}	
	
}
