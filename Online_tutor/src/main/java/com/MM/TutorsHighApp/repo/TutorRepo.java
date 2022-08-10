package com.MM.TutorsHighApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MM.TutorsHighApp.model.Student;
import com.MM.TutorsHighApp.model.Tutor;

@Repository
public interface TutorRepo extends JpaRepository<Tutor,Long> {
  
	//public List<Tutor> FindBySubject(String subject);
	
}
