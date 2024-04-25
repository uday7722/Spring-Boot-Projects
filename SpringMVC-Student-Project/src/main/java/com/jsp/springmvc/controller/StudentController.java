package com.jsp.springmvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.springmvc.entity.Student;
import com.jsp.springmvc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;	

// 1.To add the Students objects in to the database 	
	
	@RequestMapping(value = "/addStudent",method = RequestMethod.POST)
	public ModelAndView adddStudent(Student student) {		
		
		return service.addStudent(student);

	}
	
//	2.To display the data in DisplayAllStudents.jsp	
	
	@RequestMapping(value = "/DisplayAllStudents" ,method = RequestMethod.GET)
	public ModelAndView displayAllStudents() {
		
		return service.displayAllStudents();
	}

// 3a.To find the data from the database and to display in the DisplayAllStudents.jsp	
	
	@RequestMapping(value = "/UpdateStudent",method = RequestMethod.GET)
	public ModelAndView updateStudent(@RequestParam int studentId) {
		
		return service.updateStudent(studentId);
		
	}
	
// 3b.To Update the data in the DataBase
	
	@RequestMapping(value = "/SaveUpdatedStudent",method = RequestMethod.GET)
	public ModelAndView SaveUpdatedStudent(Student student) {
		
		 service.SaveUpdatedStudent(student);
		 return displayAllStudents();
		
	}
	
// 4.To Delete the Student object from database	
	
	@RequestMapping(value = "/DeleteStudent",method = RequestMethod.GET)
	public ModelAndView deleteStudent(@RequestParam int studentId) {
		
		service.deleteStudent(studentId);
		return displayAllStudents();
						
	}	
	
}
