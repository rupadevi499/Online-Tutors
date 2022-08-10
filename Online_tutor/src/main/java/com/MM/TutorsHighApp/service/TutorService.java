package com.MM.TutorsHighApp.service;


import com.MM.TutorsHighApp.model.Tutor;

import java.util.List;


public interface TutorService {
	
	public Tutor saveTutorData(Tutor tutor);

	public List<Tutor> ListOfRegisteredTutors();

	public void removetutor(Long id) ;


}
