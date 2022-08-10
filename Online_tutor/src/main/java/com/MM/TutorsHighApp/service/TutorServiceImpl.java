package com.MM.TutorsHighApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MM.TutorsHighApp.model.Student;
import com.MM.TutorsHighApp.model.Tutor;
import com.MM.TutorsHighApp.repo.TutorRepo;

import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {
	
	@Autowired
	TutorRepo tutorRepo ;
	
	
	@Override
	public Tutor saveTutorData(Tutor tutor) {
		Tutor save=tutorRepo.save(tutor);
		return save;
		// TODO Auto-generated method stub
	
	}

	@Override
	public List<Tutor> ListOfRegisteredTutors() {
		Iterable<Tutor> tl=tutorRepo.findAll();
		return (List<Tutor>) tl;
	}

	@Override
	public void removetutor(Long id) {
		tutorRepo.deleteById(id);

	}


}
