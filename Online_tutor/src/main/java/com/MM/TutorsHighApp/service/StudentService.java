package com.MM.TutorsHighApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.MM.TutorsHighApp.model.Student;
import com.MM.TutorsHighApp.model.Tutor;
import com.MM.TutorsHighApp.repo.TutorRepo;


public interface StudentService  {
	

	public Student saveStudentData(Student student);
	public List<Tutor> ListOfTutor(String subject);
	public List<Student> ListOfStudent();

	public void removeStudent(long id) ;
	 

}
