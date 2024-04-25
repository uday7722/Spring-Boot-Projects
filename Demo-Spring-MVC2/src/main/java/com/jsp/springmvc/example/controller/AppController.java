package com.jsp.springmvc.example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@RequestMapping(value = "/example1", method = RequestMethod.GET)
	public void print(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {

		String name=req.getParameter("n");

		req.setAttribute("n", name);
		RequestDispatcher dispatcher=req.getRequestDispatcher("output.jsp");
		dispatcher.forward(req, res);



	}
	
	
	
	@RequestMapping(value = "/example",method = RequestMethod.GET)
	public ModelAndView print(String n) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("n",n);
		modelAndView.setViewName("output.jsp");
		
		return modelAndView;
		
	}

}
