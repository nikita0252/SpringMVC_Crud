package com.cjc.springmvccrudadpp.daoi;

import java.util.List;

import com.cjc.springmvccrudadpp.model.Student;

public interface StudentDaoI
{
	public void saveStudent(Student s);
	
	public List<Student> loginStudent(String username, String password);
	
	public List<Student> deleteStudent(int rollno);
	
	public Student editStudent(int rollno);
	
	public List<Student> updateStudent(Student s);
	

}