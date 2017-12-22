package com.zking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zking.Entity.Student;

public class StudentShiro {

	public Student getStudentPass(String sname){
		Configuration configuration=new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Student student = (Student) session.createQuery(" from Student where sname = :name ").setParameter("name", sname).getSingleResult();
		session.close();
		sessionFactory.close();
		return student;
	}
	
}
