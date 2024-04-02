package com.hiber.service;

import java.util.List;

import com.hiber.dao.StudentDao;
import com.hiber.entity.Address;
import com.hiber.entity.Student;
import com.hiber.interfaces.Dao;
import com.hiber.utility.Utils;

public class Service {
	private static Boolean status;
	static Dao dao = new StudentDao();
	static Student student = new Student();
	static Address add = new Address();
	static String name, standred, type, city, locality, district, houseNo;
	static int sId;

	public static void resetValues() {
		name = null;
		standred = null;
		district = null;
		city = null;
		locality = null;
		houseNo = null;
		type = null;
	}

	public static Boolean create() {

		status = false;

		System.out.println("Enter Student Name: ");
		name = Utils.input().next();

		System.out.print("Enter Student Class: ");
		standred = Utils.input().next();

		System.out.print("Enter Student district: ");
		district = Utils.input().next();

		System.out.print("Enter Student city: ");
		city = Utils.input().next();

		System.out.println("Enter Student locality: ");
		locality = Utils.input().next();

		System.out.print("Enter Student house no: ");
		houseNo = Utils.input().next();

		student.setName(name);
		student.setStandred(standred);
		add.setDistrict(district);
		add.setCity(city);
		add.setLocality(locality);
		add.setHouseNumber(houseNo);
		student.setAddress(add);

		sId = dao.save(student);

		System.out.println("Saved successfully.......");

		Utils.closeSession();
		Utils.closeFactory();

		/*
		 * resetValues(), is a native method of service class which resets all the
		 * attributes of Student and Address class.
		 */
		Service.resetValues();

		status = true;

		return status;
	}

	public static Boolean update(int id) {
		status = false;
		student = Utils.getSession().get(Student.class, id);
		student.setId(student.getId());
		student.setName(student.getName());
		student.setStandred(student.getStandred());
		add.setDistrict(add.getDistrict());
		add.setCity(add.getCity());
		add.setLocality(add.getLocality());
		add.setHouseNumber(add.getHouseNumber());
		

		System.out.println("======================== Please press mentioned key to updated desired detail =======================");
		System.out.println();

		System.out.println("Student Name: 1 ");
		System.out.println("Student Class: 2");
		System.out.println("Student district: 3");
		System.out.println("Student city: 4");
		System.out.println("Student locality: 5");
		System.out.println("Student house no: 6");
		System.out.println("To Change all details  7");
		

		int choic = Utils.input().nextInt();
		switch (choic) {
		case 1:
			System.out.print("Enter Name: ");
			name = Utils.input().next();
			student.setName(name);
			break;
		case 2:
			System.out.print("Enter Class: ");
			standred = Utils.input().next();
			student.setStandred(standred);
			break;
		case 3:
			System.out.print("Enter District: ");
			district = Utils.input().next();
			add.setDistrict(district);
			break;
		case 4:
			System.out.print("Enter City: ");
			city = Utils.input().next();
			add.setCity(city);
			break;
		case 5:
			System.out.print("Enter Locality: ");
			locality = Utils.input().next();
			add.setLocality(locality);
			break;
		case 6:
			System.out.print("Enter House No.: ");
			houseNo = Utils.input().next();
			add.setHouseNumber(houseNo);
			break;
			
		case 7:
			System.out.print("Enter Name: ");
			name = Utils.input().nextLine();
			student.setName(name);
			
			System.out.print("Enter Class: ");
			standred = Utils.input().next();
			student.setStandred(standred);
			
			System.out.print("Enter District: ");
			district = Utils.input().next();
			add.setDistrict(district);
			
			System.out.print("Enter City: ");
			city = Utils.input().next();
			add.setCity(city);
			
			System.out.print("Enter Locality: ");
			locality = Utils.input().nextLine();
			add.setLocality(locality);
			
			System.out.print("Enter House No.: ");
			houseNo = Utils.input().next();
			add.setHouseNumber(houseNo);
			break;

		default:
			System.out.println("Invalid Selection.....");
			break;
		}

		dao.update(student);
		return status;
	}
	
	public static void viewStudentDetails(int id) {
		dao.getStudent(id);
	}
	
	
	
	public static Boolean deleteAStudent(int id) {
		status = false;
		student = Utils.getSession().get(Student.class, id);
		dao.delete(student);
		Utils.getSession().getTransaction().begin();
		Utils.getSession().getTransaction().commit();
		status = true;
		return status;
	}

	public static Boolean getStudentList() {
		status = false;
		List<Student> sList = dao.getAllStudents();
		
		System.out.println("Student Id      Student Name       Student Class ");
		for (Student student : sList) {
			System.out.println("  "+student.getId()+"               "+student.getName()+"                  "+student.getStandred());
		}
		
		status = true;
		return status;
	}
}
