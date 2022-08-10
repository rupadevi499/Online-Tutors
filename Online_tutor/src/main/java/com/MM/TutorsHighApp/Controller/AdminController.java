package com.MM.TutorsHighApp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.mindrot.jbcrypt.BCrypt;
import com.MM.TutorsHighApp.model.Tutor;
import com.MM.TutorsHighApp.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.MM.TutorsHighApp.model.Admin;
import com.MM.TutorsHighApp.model.Student;
import com.MM.TutorsHighApp.repo.AdminRepo;
import com.MM.TutorsHighApp.service.AdminService;
import com.MM.TutorsHighApp.service.StudentService;

import java.util.List;

@RestController
public class AdminController {
	
	@Autowired
	StudentService studentService;
	@Autowired
	AdminService adminService;
	@Autowired
	AdminRepo adminRepo;

	@Autowired
	TutorService tutorService;
	
	@GetMapping("/admin")
	public String addAdmin() {
		
		Admin admin = new Admin();
		//admin.setEmail("Hello@gmail.com");
		//admin.setPassoword(hashPassword("Admin123"));
		//adminService.saveAdminData(admin);
		Admin findById = adminRepo.SearchByEmail("Hello@gmail.com");
		
/*		checkPass("Admin123",findById);*/
		return "admin addded";
	}
	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");

	
		
	}

	
			
	@GetMapping("/adminlogin")
			public ModelAndView adminlogin() {
				return new ModelAndView("adminlogin");	
	}
	
	@GetMapping("/admins")
	public ModelAndView adminSave(HttpServletRequest req,HttpServletResponse res) {
		
		Long id = Long.parseLong(req.getParameter("id"));
		String name=req.getParameter("name");
		String qualification=req.getParameter("qualification");
		String email=req.getParameter("email");
		String password=req.getParameter("pwd");
		
	Admin admin=new Admin(id,name,qualification,email,password);
	
	Admin admin1=adminService.saveAdminData(admin);
	System.out.println("values are inserted");
	ModelAndView mv = new ModelAndView();
	mv.addObject("admin",admin1);
	mv.setViewName("adminLoginResult");
	return mv;
	
		
	} 
	/*private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	private void checkPass(String plainPassword, Admin findById) {
		if (BCrypt.checkpw(plainPassword, "hashed password"))
			System.out.println("The password matches.");
		else
			System.out.println("The password does not match.");
	}*/
	@GetMapping("/registeredstudents")
	public ModelAndView registerdStudents(){
		ModelAndView mv=new ModelAndView();

		List<Student> sl=studentService.ListOfStudent();
		mv.addObject("registeredList",sl);
		mv.setViewName("RegisteredStudentList");
		return mv;
	}

	@GetMapping("/registeredtutors")
	public ModelAndView registeredTutors() {
		ModelAndView mv = new ModelAndView();

		List<Tutor> tl = tutorService.ListOfRegisteredTutors();
		mv.addObject("tutorList", tl);
		mv.setViewName("RegisteredTutorList");
		return mv;
	}
	@GetMapping("/TutorRemove")
	public String TutorRemove(HttpServletRequest req,HttpServletResponse res){
		Long id=Long.parseLong(req.getParameter("id"));
		tutorService.removetutor(id);
		return "Tutor Removed Successfully";
	}

	@GetMapping("/StudentRemove")
	public String StudentRemove(HttpServletRequest req,HttpServletResponse res){
		Long id=Long.parseLong(req.getParameter("id"));
		studentService.removeStudent(id);
		return "Student Removed Successfully";
	}

}

