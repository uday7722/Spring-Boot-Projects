package com.jsp.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.springmvc.entity.SocialProfile;
import com.jsp.springmvc.entity.Student;
import com.jsp.springmvc.repository.SocialProfileRepository;
import com.jsp.springmvc.service.SocialProfileService;
import com.jsp.springmvc.service.StudentService;

@Controller
public class SocialProfileController {
	
	
	@Autowired
	private SocialProfileService socialProfileService;
	
	@RequestMapping(value = "/View",method = RequestMethod.GET)
	public ModelAndView displayAllProfiles(@RequestParam int studentId) {
		return socialProfileService.displayAllProfiles(studentId);
		
	}
	
	@RequestMapping("/AddNewProfile")
	public ModelAndView addProfile(@RequestParam int studentId)
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("AddNewProfile.jsp");
		modelAndView.addObject("addProfile",studentId);
		return modelAndView;
		
	}

	
	@RequestMapping(value = "/AddSocialProfile",method = RequestMethod.GET)
	public ModelAndView addSocailProfiles(@RequestParam int studentId,int profileId,String profileName,String url) {
		 return socialProfileService.addProfile(studentId,profileId,profileName,url);
		
	}

}
