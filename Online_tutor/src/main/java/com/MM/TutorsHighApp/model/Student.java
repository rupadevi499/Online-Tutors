package com.MM.TutorsHighApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Data
@Setter
@Getter
@Entity

public class Student {

	
	/*public Student(Long id2, String name2, String subject2, String qualification2, Long phno2, String email2,
			String password) {
		// TODO Auto-generated constructor stub
	}*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String subject;
	private String qualification;
	private Long phno;
	private String email;
	private String password;
	public Student(Long id, String name, String subject, String qualification, Long phno, String email,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.qualification = qualification;
		this.phno = phno;
		this.email = email;
		this.password = password;
	}
	
	public Student() {
		
	}
	

	
	 
	 

}
