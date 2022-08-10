package com.MM.TutorsHighApp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MM.TutorsHighApp.model.Student;

@Repository
public interface StudentRepo  extends CrudRepository<Student,Long>{

}
