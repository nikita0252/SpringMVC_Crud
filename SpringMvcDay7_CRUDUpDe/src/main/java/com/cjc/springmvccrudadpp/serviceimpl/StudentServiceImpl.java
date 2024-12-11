package com.cjc.springmvccrudadpp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.springmvccrudadpp.daoi.StudentDaoI;
import com.cjc.springmvccrudadpp.model.Student;
import com.cjc.springmvccrudadpp.servicei.StudentServiceI;

@Service
 public class StudentServiceImpl implements StudentServiceI

{

	@Autowired
	StudentDaoI sdi;
	public void saveStudent(Student s) 
	
	{
		
		System.out.println("Service " +s);
		sdi.saveStudent(s);
		
	}
	
	@Override
	public List<Student> loginStudent(String username, String password)
	{
		List<Student> list = sdi.loginStudent(username, password);
		
		return list;
	}
	
	@Override
	public List<Student> deleteStudent(int rollno) 
	{
		List<Student> list=sdi.deleteStudent(rollno);
		
		return list;
	}
	
	@Override
	public Student editStudent(int rollno) 
	{
		Student s=sdi.editStudent(rollno);
		
		return s;
	}

	@Override
	public List<Student> updateStudent(Student s)
	{
		return sdi.updateStudent(s);
		
	}
	

}
