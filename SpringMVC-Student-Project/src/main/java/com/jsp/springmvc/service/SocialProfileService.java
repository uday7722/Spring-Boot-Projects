package com.jsp.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.springmvc.entity.SocialProfile;
import com.jsp.springmvc.entity.Student;
import com.jsp.springmvc.repository.SocialProfileRepository;
import com.jsp.springmvc.repository.StudentRepository;

@Service
public class SocialProfileService {

	
	@Autowired 
	private SocialProfileRepository socialProfileRepository;

	public ModelAndView displayAllProfiles(int studentId) {
		Student student=socialProfileRepository.findStudentById(studentId);
	
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("displayProfile",student);
		modelAndView.setViewName("DisplayAllProfiles.jsp");
		
		
		
		return modelAndView;
	}

	public ModelAndView addProfile(int studentId,int profileId,String profileName,String url) {
		Student student=socialProfileRepository.findStudentById(studentId);
		
		SocialProfile socialProfile=new SocialProfile();
		socialProfile.setProfileId(profileId);
		socialProfile.setProfileName(profileName);
		socialProfile.setUrl(url);
		
		socialProfile.setStudent(student);
		
		student.getList().add(socialProfile);
		
		socialProfileRepository.addProfile(socialProfile, student);
		
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("displayProfile",student);
		modelAndView.setViewName("DisplayAllProfiles.jsp");
		
		
		return modelAndView;
	}
	
	

}
