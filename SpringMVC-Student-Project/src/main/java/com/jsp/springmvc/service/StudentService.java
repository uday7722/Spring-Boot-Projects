package com.jsp.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.springmvc.entity.Student;
import com.jsp.springmvc.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

// 1.To add the Students objects in to the database 

	public ModelAndView addStudent(Student student) {

		repository.addStudent(student);

		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("index.jsp");

		return modelAndView;
	}

//	2.To display the data in DisplayAllStudents.jsp	

	public ModelAndView displayAllStudents() {
		List<Student> students= repository.displayAllStudents();

		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("displayList",students);
		modelAndView.setViewName("DisplayAllStudents.jsp");
		return modelAndView;
	}

// 3a.To find the data from the database and to display in the DisplayAllStudents.jsp
	
	public ModelAndView updateStudent(int studentId) {
		Student student= repository.updateStudent(studentId);

		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("updateStudent",student);
		modelAndView.setViewName("UpdateStudent.jsp");

		return modelAndView;
	}
	
// 3b.To Update the data in the DataBase	


	public ModelAndView SaveUpdatedStudent(Student student) {
		Student students=( Student) repository.SaveUpdatedStudent(student);
		ModelAndView modelAndView=new ModelAndView();

		modelAndView.addObject("displayList",students);
		modelAndView.setViewName("DisplayAllStudents.jsp");

		return modelAndView;
	}

// 4.To Delete the Student object from database

	public ModelAndView deleteStudent(int studentId) {
		repository.deleteStudent(studentId);

		ModelAndView modelAndView=new ModelAndView();
		//		modelAndView.addObject("displayList",student);
		modelAndView.setViewName("DisplayAllStudents.jsp");

		return modelAndView;
	}

}
