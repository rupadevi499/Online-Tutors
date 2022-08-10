package com.MM.TutorsHighApp.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MM.TutorsHighApp.model.Admin;
import com.MM.TutorsHighApp.model.Student;

@Repository
public interface AdminRepo extends CrudRepository<Admin, Long> {

	//Admin findByEmailandID(String string,Long Id);
	
	
	@Query(value="select * from admin where email=:Email",nativeQuery=true)
	Admin SearchByEmail(@Param("Email")String email);

	
	
	

}

