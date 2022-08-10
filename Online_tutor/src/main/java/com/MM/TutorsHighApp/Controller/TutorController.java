package com.MM.TutorsHighApp.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.MM.TutorsHighApp.model.Tutor;
import com.MM.TutorsHighApp.service.TutorService;

@RestController
public class TutorController {
	
	@Autowired
	TutorService tutorService;
	
	
	
	@GetMapping("/tutorlogin")
		public ModelAndView tutorlogin() {
			return new ModelAndView("tutorlogin");
	}
	
	@GetMapping("/tutor")
    public ModelAndView tutorSave(HttpServletRequest req,HttpServletResponse res) {
		
		Long id=Long.parseLong(req.getParameter("id"));
		String name=req.getParameter("name");
		String qualification=req.getParameter("qualification");
		String subject=req.getParameter("subject");
		int experience= Integer.parseInt(req.getParameter("experience"));
		String email=req.getParameter("email");
		Long phno=Long.parseLong(req.getParameter("phno"));
		String password=req.getParameter("pwd");
		
	Tutor tutor = new Tutor(id,name,qualification,subject,experience,phno,email,password);
	
		
		
		Tutor tutor1=tutorService.saveTutorData(tutor);
		System.out.println("values are Inserted");
		ModelAndView mv = new ModelAndView();
		mv.addObject("Tutor", tutor1);
		mv.setViewName("tutorLoginResult");
		return mv;
		
	}

}
