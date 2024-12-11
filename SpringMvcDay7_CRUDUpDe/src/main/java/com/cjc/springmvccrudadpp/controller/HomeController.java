package com.cjc.springmvccrudadpp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.springmvccrudadpp.model.Student;
import com.cjc.springmvccrudadpp.servicei.StudentServiceI;

@Controller
public class HomeController
{
	@Autowired
	StudentServiceI ssi;
	
	@RequestMapping("/")
	public String preLogin()	
	{
		return "login";
	}
	
	@RequestMapping("/openregisterpage")
	public String preRegister()
	{
		return "register";
	}
	
	@RequestMapping("/save")
	public String saveStudent(@ModelAttribute Student s)
	{
		System.out.println(s);
		ssi.saveStudent(s);
		return "login";
	}
	
	@RequestMapping("/login")
	public String loginStudent(@RequestParam("username")String username,@RequestParam("password") String password, Model m)
	{ 
		List<Student> list=ssi.loginStudent(username, password);
		
			if(!list.isEmpty())
			{
				m.addAttribute("data",list);
				return "success";
			}
			else 
			{
				System.out.println("Enter Valid ID and PASSWORD");
				
				return "invalid";
			}
		
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("rollno") int rollno,Model m)
	{
		List<Student> list = ssi.deleteStudent(rollno);
		m.addAttribute("data",list);
		
		return "success";
	}
	
	@RequestMapping("/edit")
	public String editStudent(@RequestParam("rollno") int rollno,Model m)
	{
		Student s = ssi.editStudent(rollno);
		m.addAttribute("stu", s);
		return "edit";
	}
	
	@RequestMapping("/update")
	public String updateStudent(@ModelAttribute Student s,Model m)
	{
		List<Student> list = ssi.updateStudent(s);
		m.addAttribute("data", list);
		return "success";
		
	}
	
	@RequestMapping("/logout")
	public String Logout()
	{
		return "invalid";
	}
	}

	
	
