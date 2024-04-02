package com.hiber.todo;

import com.hiber.dao.StudentDao;
import com.hiber.interfaces.Dao;
import com.hiber.service.Service;
import com.hiber.utility.Utils;

public class App {
	private static int id=0;
	static Dao dao = new StudentDao();
	public static void main(String[] args) {
		System.out.println("===================== Welcome to Student & Teacher Management portal ====================");
		System.out.println("Please press 1 - to add a student");
		System.out.println("Please press 2 - to update student details");
		System.out.println("Please press 3 - to delete a student");
		System.out.println("Please press 4 - to view the details of a student");
		System.out.println("Please press 5 - to view list of all the students");

		int choice = Utils.input().nextInt();
		String wantToContinue = null;

		switch (choice) {
		case 1:
			Service.create();
			break;

		case 2:
			System.out.println("Please enter a valid student id ....");
			id = Utils.input().nextInt();

			Service.update(id);
			System.out.println("Student updated details are.........");
			dao.getStudent(id);
			break;
			
		case 3:
			System.out.print("Enter student id: ");
			id = Utils.input().nextInt();
			Service.deleteAStudent(id);
			break;
			
		case 4:
			System.out.print("Enter student id: ");
			id = Utils.input().nextInt();
			Service.viewStudentDetails(id);
			break;
			
		case 5:
			Service.getStudentList();
			break;

		default:
			System.out.println("Invalid selection.................");
			break;
		}

	}
}
