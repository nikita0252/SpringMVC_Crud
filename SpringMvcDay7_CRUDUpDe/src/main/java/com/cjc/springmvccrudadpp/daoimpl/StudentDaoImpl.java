package com.cjc.springmvccrudadpp.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.cjc.springmvccrudadpp.daoi.StudentDaoI;
import com.cjc.springmvccrudadpp.model.Student;



@Repository
public class StudentDaoImpl implements StudentDaoI
{

	@Autowired
	SessionFactory sf;
	
	
	@Override
	public void saveStudent(Student s)
	{
		System.out.println("Dao "+s);
		Session session=sf.openSession();
		session.save(s);
		session.beginTransaction().commit();
	
		
	}


	@Override
	public List<Student> loginStudent(String username, String password)
	{
		
		Session session = sf.openSession();
		
		if(username.equals("Admin") && password.equals("Admin"))
		{
			List<Student> list=session.createQuery("from Student").getResultList();
			return list;
		}
		else
		{
		Query<Student> query=session.createQuery("from Student where username=?1 and password=?2");
			query.setParameter(1, username);
			query.setParameter(2, password);
			
			List<Student> list=query.getResultList();
		
		return list;
		}
	}


	@Override
	public List<Student> deleteStudent(int rollno) 
	{
		Session session = sf.openSession();
		Query<Student> query=session.createQuery("delete from Student where rollno=?1 ");
			query.setParameter(1, rollno);
		Transaction t = session.beginTransaction();
		query.executeUpdate();
		t.commit();
		
		Query<Student> query2 = session.createQuery("from Student");
		return query2.getResultList();
	}


	@Override
	public Student editStudent(int rollno) 
	{
		Session session = sf.openSession();
		Student s = session.get(Student.class, rollno);
		
		return s;
	}


	@Override
	public List<Student> updateStudent(Student s)
	{
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
			session.merge(s);
				tx.commit();
				
		Query<Student> query = session.createQuery("from Student");
		List<Student> list = query.getResultList();
		
		return list;
	}

	
	
	
	
}
