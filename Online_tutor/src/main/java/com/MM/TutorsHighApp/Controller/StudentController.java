package com.MM.TutorsHighApp.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.MM.TutorsHighApp.model.Student;
import com.MM.TutorsHighApp.model.Tutor;
import com.MM.TutorsHighApp.repo.TutorRepo;
import com.MM.TutorsHighApp.service.StudentService;



@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	TutorRepo tutorrepo;
	
	@GetMapping("/studentlogin")
	public ModelAndView studentlogin() {
		return new ModelAndView("studentlogin");
	}
  
	@GetMapping("/student")
	public ModelAndView studentSave(HttpServletRequest req,HttpServletResponse res) {
		
		Long id=Long.parseLong(req.getParameter("id"));
		String name=req.getParameter("name");
		String qualification=req.getParameter("qualification");
		String subject=req.getParameter("subject");
		String email=req.getParameter("email");
		Long phno=Long.parseLong(req.getParameter("phno"));
		String password=req.getParameter("pwd");
		
	Student student = new Student(id,name,subject,qualification,phno,email,password);
	
		
		
		Student student1=studentService.saveStudentData(student);
		System.out.println("values are Inserted");
		ModelAndView mv = new ModelAndView();
		mv.addObject("student", student1);
		mv.setViewName("studentResultPage");
		return mv;
		
	}
	@GetMapping("/StudentSearch")
	public  ModelAndView studentResultPage(HttpServletRequest req,HttpServletResponse res) {
		String sub1=req.getParameter("maths");
		String sub2=req.getParameter("english");
		ModelAndView mv=new ModelAndView();
		List<Tutor> tutorlist1 = null;
		if(sub1!=null) {
			if (sub1.equalsIgnoreCase("maths")) {


				tutorlist1 = studentService.ListOfTutor(sub1);
				mv.addObject("tutorlist", tutorlist1);
			}
		}
		if(sub2!=null){
		if(sub2.equalsIgnoreCase("english")) {
			List<Tutor> tutorlist2=studentService.ListOfTutor(sub2);
			mv.addObject("tutorlist",tutorlist2);

		}
		}

		mv.setViewName("TutorList");

		return mv;

	}
}
