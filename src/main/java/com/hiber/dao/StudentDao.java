package com.hiber.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hiber.entity.Student;
import com.hiber.interfaces.Dao;
import com.hiber.utility.Utils;

public class StudentDao implements Dao{
	SessionFactory factory = null;
	Session session = null;
	Boolean status = false;

	@Override
	public int save(Student student) {
		@SuppressWarnings("deprecation")
		int id = (int) Utils.getSession().save(student);
		Utils.getSession().getTransaction().begin();
		Utils.getSession().getTransaction().commit();
		return id;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Boolean update(Student student) {
		
		Utils.getSession().update(student);
		Utils.getSession().getTransaction().begin();
		Utils.getSession().getTransaction().commit();
		status = true;
		return status;
	}

	@Override
	public Boolean delete(Student student) {
		status = false;
		Utils.getSession().delete(student);
		status = true;
		return status;
	}



	@Override
	public List<Student> getAllStudents() {
		List<Student> sList = new ArrayList<Student>();
		String q = "from Student";
		Query<Student> query = Utils.getSession().createQuery(q);
		sList = query.list();
		return sList;
	}

	@Override
	public Student getStudent(int id) {
		Student student = Utils.getSession().get(Student.class, id);
		System.out.println("Student Id: " + student.getId());
		System.out.println("Student Name: " + student.getName());
		System.out.println("Student Class: " + student.getStandred());
		System.out.println("Student District: " + student.getAddress().getDistrict());
		System.out.println("Student City: " + student.getAddress().getCity());
		System.out.println("Student Locality: " + student.getAddress().getLocality());
		System.out.println("Student House No.: " + student.getAddress().getHouseNumber());
		System.out.println("Date Of Addminssion: " + student.getCreateDate());
		
		Utils.closeSession();
		Utils.closeFactory();
		return student;
		
	}


}
