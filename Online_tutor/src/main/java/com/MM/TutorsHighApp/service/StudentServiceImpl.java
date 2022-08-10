package com.MM.TutorsHighApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MM.TutorsHighApp.model.Student;
import com.MM.TutorsHighApp.model.Tutor;
import com.MM.TutorsHighApp.repo.StudentRepo;
import com.MM.TutorsHighApp.repo.TutorRepo;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentRepo studentRepo;
	

	 @Autowired 
	 TutorRepo repo;

	@Override
	public Student saveStudentData(Student student) {
		Student save=studentRepo.save(student);
		return save;
		
	}
	@Override
    
	public List<Tutor> ListOfTutor(String subject){
		List<Tutor> tl=repo.findAll();
		List<Tutor> actualList=tl.stream().filter(i->i.getSubject().equalsIgnoreCase(subject)).collect(Collectors.toList());
		return actualList;
		
	}

	@Override
	public List<Student> ListOfStudent() {
		Iterable<Student> sl=studentRepo.findAll();
		return (List<Student>) sl;
	}

	@Override
	public void removeStudent(long id) {
		studentRepo.deleteById(id);
	}

}

