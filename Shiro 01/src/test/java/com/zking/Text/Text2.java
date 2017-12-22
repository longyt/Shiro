package com.zking.Text;

import java.util.List;

import org.jboss.jandex.Main;

import com.zking.Entity.Student;
import com.zking.dao.StudentShiro;

public class Text2 {
	
	public static void main(String[] args) {
		
		StudentShiro studentShiro=new StudentShiro();
		Student student = studentShiro.getStudentPass("jk");
		System.out.println(student.getAge());
	}

}
