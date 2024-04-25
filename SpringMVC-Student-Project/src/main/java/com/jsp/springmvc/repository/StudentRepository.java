package com.jsp.springmvc.repository;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.jsp.springmvc.entity.SocialProfile;
import com.jsp.springmvc.entity.Student;

@Repository
public class StudentRepository {

	Scanner scanner=new Scanner(System.in);

	public static Session getSession() {
		Configuration configuration=new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(SocialProfile.class);	
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		return session;

	}	

// 1.To add the Students objects in to the database 

	public Student addStudent(Student student) {
		Session session=StudentRepository.getSession();
		Transaction transaction=session.beginTransaction();
		session.save(student);
		transaction.commit();
		session.close();
		return student;
	}

//	2.To display the data in DisplayAllStudents.jsp
	
	public List<Student> displayAllStudents() {
		Session session=StudentRepository.getSession();
		Transaction transaction=session.beginTransaction();

		Query<Student> query=session.createQuery("From Student");
		List<Student> students=query.list();	
		transaction.commit();
		session.close();

		return students;
	}
	
// 3a.To find the data from the database and to display in the DisplayAllStudents.jsp
	
	public Student updateStudent(int studentId) {

		Session session=StudentRepository.getSession();
		Transaction transaction=session.beginTransaction();

		Student student=session.get(Student.class, studentId);

		transaction.commit();
		session.close();

		return student;
	}
	
// 3b.To Update the data in the DataBase
	
	public Student SaveUpdatedStudent(Student student) {
		Session session=StudentRepository.getSession();
		Transaction transaction=session.beginTransaction();
		
		session.update(student);
		
		transaction.commit();
		session.close();

		return student;
	}
	
// 4.To Delete the Student object from database
	
	public Student deleteStudent(int studentId) {
		Session session=StudentRepository.getSession();
		Transaction transaction=session.beginTransaction();
		
		Student student=session.get(Student.class, studentId);
		session.delete(student);

		transaction.commit();
		session.close();
		return student;
	}
	
	public Student getStudentById(int studentId) {
		Session session=StudentRepository.getSession();
		Transaction transaction=session.beginTransaction();
		
		Student student=session.get(Student.class, studentId);
			
		transaction.commit();
		session.close();
		
		return student;
		
	}
}
