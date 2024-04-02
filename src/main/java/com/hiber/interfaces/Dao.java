package com.hiber.interfaces;

import java.util.List;

import com.hiber.entity.Student;

public interface Dao {

	public int save(Student student);
	public Boolean update(Student student);
	public Boolean delete(Student student);
	public Student getStudent(int id);
	public List<Student> getAllStudents();
}
