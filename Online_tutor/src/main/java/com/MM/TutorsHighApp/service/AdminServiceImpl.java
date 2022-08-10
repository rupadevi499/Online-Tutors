package com.MM.TutorsHighApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MM.TutorsHighApp.model.Admin;
import com.MM.TutorsHighApp.model.Student;
import com.MM.TutorsHighApp.repo.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepo adminRepo;
	
	@Override
	public Admin saveAdminData(Admin admin) {
		
		Admin save = adminRepo.save(admin);
		
		
		return save;
	}

}

