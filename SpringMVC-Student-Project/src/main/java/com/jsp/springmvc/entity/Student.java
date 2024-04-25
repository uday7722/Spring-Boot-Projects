package com.jsp.springmvc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	@Id
	private int studentId;
	private String studentName;
	private String studentEmail;
	private int studentClass;
	
	@OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
	private List<SocialProfile> list=new ArrayList<SocialProfile>();
	
	public List<SocialProfile> getList() {
		return list;
	}
	
	public void setList(List<SocialProfile> list) {
		this.list = list;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getStudentEmail() {
		return studentEmail;
	}
	
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
	public int getStudentClass() {
		return studentClass;
	}
	
	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}
	
	

}
