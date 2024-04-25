package com.jsp.springmvc.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springmvc.entity.SocialProfile;
import com.jsp.springmvc.entity.Student;

@Repository
public class SocialProfileRepository {
	
	public static Session getSession() {
		
	Configuration configuration=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(SocialProfile.class);
	SessionFactory factory=configuration.buildSessionFactory();
	Session session=factory.openSession();
	
	return session;
	
	}
	
	public SocialProfile displayAllProfiles(int studentId) {
		
		Session session=SocialProfileRepository.getSession();
		Transaction transaction=session.beginTransaction();
		
		SocialProfile socialProfile=session.get(SocialProfile.class, studentId);
		
		transaction.commit();
		session.close();
		
		return socialProfile;
		
		
	}

	public Student findStudentById(int studentId) {
		Session session=SocialProfileRepository.getSession();
		Transaction transaction=session.beginTransaction();
		
		Student student=session.get(Student.class, studentId);
		
		
		transaction.commit();
		session.close();
		
		
		
		return student;
	}
	
	public void addProfile(SocialProfile socialProfile,Student student) {
		Session session=SocialProfileRepository.getSession();
		Transaction transaction=session.beginTransaction();
		
		session.save(socialProfile);
		session.update(student);
		
		
		
		transaction.commit();
		session.close();
		
	
		
		
	}
	
	

}
