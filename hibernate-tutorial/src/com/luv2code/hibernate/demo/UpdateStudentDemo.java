package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create a session
		Session session=factory.getCurrentSession();
		
		
		try {
				
			int studentId = 1;
			
			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
		
		// 
	}

	private static void displayStudents(List<Student> theStudents) {
		// display the students
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent.getId()+" "+tempStudent.getFirstName()+" "+tempStudent.getLastName());
		}
	}

}


